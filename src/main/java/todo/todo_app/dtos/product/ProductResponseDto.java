package todo.todo_app.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import todo.todo_app.models.CommandModel;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductResponseDto {

    private Long id;
    private  String name;
    private Integer price;
    private Integer quantity;
    private List<CommandModel> commands;

}
