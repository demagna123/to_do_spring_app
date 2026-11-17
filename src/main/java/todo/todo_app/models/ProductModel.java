package todo.todo_app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Integer price;
    private Integer quantity;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonIgnore // Évite la boucle infinie dans Postman
    private List<CommandModel> commands;


    public Integer get() {
        return null;
    }
}
