@Controller
public class TaskControllerWS {
    @MessageMapping("/task.move")
    @SendTo("/topic/board/{boardId}")
    public Task moveTask(@DestinationVariable String boardId, Task task) {
        // save changes
        return task;
    }
}

