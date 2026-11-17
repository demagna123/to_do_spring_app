package todo.todo_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import todo.todo_app.models.CommandModel;

import java.util.Optional;

public interface CommandRepository extends JpaRepository<CommandModel ,Long> {

    @Override
    Optional<CommandModel> findById(Long id);
}
