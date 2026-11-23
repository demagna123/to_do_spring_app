package todo.todo_app.controllers;

import org.springframework.web.bind.annotation.*;
import todo.todo_app.models.TaskModel;
import todo.todo_app.services.implementions.TaskService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("tasks/")
public class TaskController {


    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping("/create")
    public TaskModel createTask(@RequestBody TaskModel taskModel){
        return taskService.createTask(taskModel);
    }

    @GetMapping("/list")
    public List<TaskModel> getAllTask(){
        return taskService.getAllTask();
    }

    @PutMapping("/update/{id}")
    public TaskModel updateTaskById(@PathVariable Long id, @RequestBody TaskModel taskModel){
        return taskService.updateTaskById(id,taskModel);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTaskById(@PathVariable Long id){
        taskService.deleteTaskById(id);
    }
}
