package todo.todo_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import todo.todo_app.models.CategoryModel;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryModel ,Long> {

    @Override
    Optional<CategoryModel> findById(Long id);
}
