package todo.todo_app.dtos.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import todo.todo_app.models.CategoryModel;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDto {

    private Long id;
    private String name;
    private String description;
    private CategoryModel category;
}
