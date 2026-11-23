package todo.todo_app.dtos.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import todo.todo_app.models.BookModel;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponseDto {

    private Long id;
    private String name;
    private List<BookModel> books;



}
