package todo.todo_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import todo.todo_app.models.BookModel;

import java.util.Optional;

public interface BookRepository extends JpaRepository<BookModel, Long > {
    @Override
    Optional<BookModel> findById(Long id);
}
