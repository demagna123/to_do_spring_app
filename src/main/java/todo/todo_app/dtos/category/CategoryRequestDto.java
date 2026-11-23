package todo.todo_app.dtos.category;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryRequestDto {

    @NotNull(message = "Le nom de la categorie est requise")
    private String name;

}
