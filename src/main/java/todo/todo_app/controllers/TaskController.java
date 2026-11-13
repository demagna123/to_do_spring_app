package todo.todo_app.controllers;

import org.springframework.web.bind.annotation.*;
import todo.todo_app.models.TaskModel;
import todo.todo_app.services.implementions.TaskServiceImplementation;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("tasks/")
public class TaskController {


    private final TaskServiceImplementation taskServiceImplementation;

    public TaskController(TaskServiceImplementation taskServiceImplementation){
        this.taskServiceImplementation = taskServiceImplementation;
    }

    @PostMapping("/create")
    public TaskModel createTask(@RequestBody TaskModel taskModel){
        return taskServiceImplementation.createTask(taskModel);
    }

    @GetMapping("/list")
    public List<TaskModel> getAllTask(){
        return taskServiceImplementation.getAllTask();
    }

    @PutMapping("/update/{id}")
    public TaskModel updateTaskById(@PathVariable Long id, @RequestBody TaskModel taskModel){
        return taskServiceImplementation.updateTaskById(id,taskModel);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTaskById(@PathVariable Long id){
        taskServiceImplementation.deleteTaskById(id);
    }
}
