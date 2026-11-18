package todo.todo_app.dtos.command;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommandRequestDto {

    @NotNull(message = "L'id du client est obligatoire")
    private Long clientId;

    @NotNull(message = "L'id du produit est obligatoire")
    private Long productId;

    @NotNull(message = "La quantité est obligatoire")
    @Positive(message = "La quantité doit être supérieure à 0")
    private Integer quantity;
}
