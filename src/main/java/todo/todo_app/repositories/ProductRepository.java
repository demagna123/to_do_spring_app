package todo.todo_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import todo.todo_app.models.ProductModel;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {

    @Override
    Optional<ProductModel> findById(Long id);
}
