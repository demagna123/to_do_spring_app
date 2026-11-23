package todo.todo_app.dtos.client;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientRequestDto {

    @NotNull(message = "Le nom du client est requis")
    private String lastName;

    @NotNull(message = "Le prenom du client est requis")
    private String firstName;

    @NotNull(message = "Le genre du client est requis")
    private String gender;


    @NotNull(message = "La ville du client est requise")
    private String town;






}
