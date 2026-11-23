package todo.todo_app.dtos.book;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import todo.todo_app.models.CategoryModel;

@Getter
@Setter
public class BookRequestDto {

    @NotNull(message = "Le nom du livre est requis")
    private String name;

    private String description;

    @NotNull(message = "La categorie est obligatoire")
    private CategoryModel category;
}
