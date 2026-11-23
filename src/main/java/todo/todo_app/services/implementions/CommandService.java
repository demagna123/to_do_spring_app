package todo.todo_app.services.implementions;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import todo.todo_app.dtos.command.CommandRequestDto;
import todo.todo_app.dtos.command.CommandResponseDto;
import todo.todo_app.models.ClientModel;
import todo.todo_app.models.CommandModel;
import todo.todo_app.models.ProductModel;
import todo.todo_app.repositories.ClientRepository;
import todo.todo_app.repositories.CommandRepository;
import todo.todo_app.repositories.ProductRepository;

import java.util.List;

@Transactional
@Service
public class CommandService implements todo.todo_app.services.CommandService {

    private final CommandRepository commandRepository;
    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;

    public CommandService(CommandRepository commandRepository, ClientRepository clientRepository, ProductRepository productRepository ){
        this.commandRepository  = commandRepository;
        this.clientRepository=clientRepository;
        this.productRepository =productRepository;
    }

    public List<CommandResponseDto> getAllCommand() {
        return commandRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public CommandResponseDto getCommandById(Long id) {
        return toResponse(findCommandOrThrow(id));
    }
    // ---------- Méthodes utilitaires ----------

    private CommandModel findCommandOrThrow(Long id) {
        return commandRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Commande introuvable avec l'id " + id));
    }

    private CommandResponseDto toResponse(CommandModel command) {
        ClientModel client = command.getClient();
        ProductModel product = command.getProduct();

        return CommandResponseDto.builder()
                .id(command.getId())
                .clientId(client.getId())
                .clientFullName(client.getFirstName() + " " + client.getLastName())
                .productId(product.getId())
                .productName(product.getName())
                .unitPrice(Long.valueOf(product.getPrice()))
                .quantity(command.getQuantity())
                .totalPrice(Long.valueOf(command.getTotalPrice()))
                .build();
    }

    public CommandResponseDto createCommand(CommandRequestDto request) {

        ClientModel client = clientRepository.findById(request.getClientId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Client introuvable avec l'id " + request.getClientId()));

        ProductModel product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Produit introuvable avec l'id " + request.getProductId()));

        int quantity = request.getQuantity();

        if (product.getQuantity() == null || product.getQuantity() < quantity) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Stock insuffisant pour " + product.getName()
                            + " (disponible : " + product.getQuantity() + ", demandé : " + quantity + ")");
        }

        // Décrémenter le stock
        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);

        // Construire l'entité à partir du DTO
        CommandModel command = CommandModel.builder()
                .client(client)
                .product(product)
                .quantity(quantity)
                .totalPrice((int) Math.multiplyExact(product.getPrice(), (long) quantity))
                .build();

        return toResponse(commandRepository.save(command));
    }

    @Transactional
    public void deleteCommandById(Long id) {
        CommandModel command = findCommandOrThrow(id);

        // Annuler la commande remet le stock
        ProductModel product = command.getProduct();
        product.setQuantity(product.getQuantity() + command.getQuantity());
        productRepository.save(product);

        commandRepository.delete(command);
    }

}
