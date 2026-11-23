package todo.todo_app.dtos.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponseDto {

    private Long id;
    private  String lastName;
    private  String firstName;
    private  String gender;
    private  String town;

}
