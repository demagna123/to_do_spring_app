package todo.todo_app.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import todo.todo_app.models.TaskModel;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<TaskModel,Long > {

    @Override
    Optional<TaskModel> findById(Long id);


}
