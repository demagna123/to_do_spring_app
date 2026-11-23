package todo.todo_app.dtos.product;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDto {

    @NotNull(message = "Le nom du produit est obligatoir")
    private String name;

    @NotNull(message = "Le prix du produit est obligatoir")
    private Integer price;

    private String description;

    @NotNull(message = "La quantite du produit est obligatoire")
    private Integer quantity;


}
