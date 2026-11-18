package todo.todo_app.dtos.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommandResponseDto {

    private Long id;

    private Long clientId;
    private String clientFullName;

    private Long productId;
    private String productName;
    private Long unitPrice;

    private Integer quantity;
    private Long totalPrice;
}
