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
public class TaskModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private  String name;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    private String description;


}
