package com.example.taskcollab.controller;

import com.example.taskcollab.model.Task;
import com.example.taskcollab.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Get tasks by list with pagination & search
    @GetMapping
    public Page<Task> getTasks(
            @RequestParam Long listId,
            @RequestParam(required = false) String search,
            Pageable pageable) {
        if (search != null && !search.isEmpty()) {
            return taskService.findByListIdAndTitleContaining(listId, search, pageable);
        }
        return taskService.findByListId(listId, pageable);
    }

    // Create task in specific list
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.create(task);
    }

    // Update task (title, description, assignee)
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        taskService.update(id, taskDetails.getTitle(), taskDetails.getDescription(), 
                          taskDetails.getAssignedTo());
        return taskService.findById(id);
    }

    // ⭐ DRAG & DROP MOVE ENDPOINT ⭐
    @PutMapping("/{id}/move")
    public Task moveTask(@PathVariable Long id, @RequestBody MoveRequest moveRequest) {
        return taskService.moveTask(id, moveRequest.getListId(), moveRequest.getPosition());
    }

    // Delete task
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.delete(id);
    }
}

// DTO for move request
class MoveRequest {
    private Long listId;
    private Integer position;
    
    // constructors, getters, setters
    public Long getListId() { return listId; }
    public void setListId(Long listId) { this.listId = listId; }
    public Integer getPosition() { return position; }
    public void setPosition(Integer position) { this.position = position; }
}

