package com.example.taskcollab.controller;

import com.example.taskcollab.model.Board;
import com.example.taskcollab.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/boards")
public class BoardController {

    @Autowired
    private BoardService boardService;

    // Get all boards with pagination & search
    @GetMapping
    public Page<Board> getBoards(
            @RequestParam(required = false) String search,
            Pageable pageable) {
        if (search != null && !search.isEmpty()) {
            return boardService.findByNameContaining(search, pageable);
        }
        return boardService.findAll(pageable);
    }

    // Create new board
    @PostMapping
    public Board createBoard(@RequestBody Board board) {
        return boardService.create(board);
    }

    // Get single board with lists/tasks
    @GetMapping("/{id}")
    public Board getBoard(@PathVariable Long id) {
        return boardService.findById(id);
    }

    // Update board name
    @PutMapping("/{id}")
    public Board updateBoard(@PathVariable Long id, @RequestBody Board boardDetails) {
        return boardService.update(id, boardDetails.getName());
    }

    // Delete board
    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable Long id) {
        boardService.delete(id);
    }
}

