package todo.todo_app.services.implementions;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import todo.todo_app.models.TaskModel;
import todo.todo_app.repositories.TaskRepository;

import java.util.List;
import java.util.Optional;

@Transactional
@Service

public class TaskServiceImplementation {
    private final TaskRepository taskRepository;
    public TaskServiceImplementation(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<TaskModel>  getAllTask(){
      return  taskRepository.findAll();
    }

    public TaskModel createTask(TaskModel taskmodel){
        return  taskRepository.save(taskmodel);
    }

    public TaskModel updateTaskById(Long id, TaskModel taskmodel){

        TaskModel task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Tache non trouvé"));
        task.setName(task.getName());
        task.setStatus(task.getStatus());
        task.setDescription(task.getDescription());

        return  taskRepository.save(task);
    }

    public void deleteTaskById(Long id){
        taskRepository.deleteById(id);
    }
}
