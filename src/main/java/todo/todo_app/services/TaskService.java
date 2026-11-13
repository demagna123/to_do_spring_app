package todo.todo_app.services;

import todo.todo_app.models.TaskModel;

import java.util.List;

public interface TaskService {

    List<TaskModel> getAllTask();
    TaskModel createTask(TaskModel taskmodel);
    TaskModel updateTaskById(Long id, TaskModel taskmodel);
    void deleteTaskById(Long id);
}
