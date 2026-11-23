package todo.todo_app.controllers;

import org.springframework.web.bind.annotation.*;
import todo.todo_app.models.ClientModel;
import todo.todo_app.services.implementions.ClientService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("clients")
public class ClientController {
    private final ClientService clientService;

    public ClientController (ClientService clientService){
        this.clientService = clientService;
    }

    @GetMapping
    public List<ClientModel> getAllClient(){
      return   clientService.getAllClient();
    }

    @PostMapping
    public ClientModel createClient( @RequestBody ClientModel clientModel){
        return  clientService.createClient(clientModel);
    }

    @PutMapping("/{id}")
    public ClientModel updateClientById( @PathVariable Long id, @RequestBody ClientModel clientModel){
        return  clientService.updateClientById(id,clientModel);
    }

    @DeleteMapping("/{id}")
    public  void deleteClientById( @PathVariable Long id){
        clientService.deleteClientById(id);
    }
}
