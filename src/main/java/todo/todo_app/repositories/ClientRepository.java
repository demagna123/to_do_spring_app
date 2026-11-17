package todo.todo_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import todo.todo_app.models.ClientModel;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<ClientModel , Long> {

    @Override
    Optional<ClientModel> findById(Long id);
}
