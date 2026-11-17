package todo.todo_app.controllers;

import org.springframework.web.bind.annotation.*;
import todo.todo_app.models.ClientModel;
import todo.todo_app.services.implementions.ClientServiceImplementation;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("clients")
public class ClientController {
    private final ClientServiceImplementation clientServiceImplementation;

    public ClientController (ClientServiceImplementation clientServiceImplementation){
        this.clientServiceImplementation = clientServiceImplementation;
    }

    @GetMapping
    public List<ClientModel> getAllClient(){
      return   clientServiceImplementation.getAllClient();
    }

    @PostMapping
    public ClientModel createClient( @RequestBody ClientModel clientModel){
        return  clientServiceImplementation.createClient(clientModel);
    }

    @PutMapping("/{id}")
    public ClientModel updateClientById( @PathVariable Long id, @RequestBody ClientModel clientModel){
        return  clientServiceImplementation.updateClientById(id,clientModel);
    }

    @DeleteMapping("/{id}")
    public  void deleteClientById( @PathVariable Long id){
        clientServiceImplementation.deleteClientById(id);
    }
}
