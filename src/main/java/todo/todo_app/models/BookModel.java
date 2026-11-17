package todo.todo_app.models;

import jakarta.persistence.*;
import lombok.*;
import todo.todo_app.enums.StatusEnum;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id") // Nom de la colonne de clé étrangère dans H2
    private CategoryModel category;
    private  String name;

    private String description;
}
