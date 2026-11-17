package todo.todo_app.services.implementions;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import todo.todo_app.models.ClientModel;
import todo.todo_app.repositories.ClientRepository;

import java.util.List;
@Transactional
@Service
public class ClientServiceImplementation {

    private final ClientRepository clientRepository;

    public ClientServiceImplementation(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }


    public List<ClientModel> getAllClient(){
        return clientRepository.findAll();
    }

    public ClientModel createClient (ClientModel clientModel){
        return  clientRepository.save(clientModel);
    }


    public ClientModel updateClientById(Long id, ClientModel clientModel){
        ClientModel client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client non trouvé"));

        client.setFirstName(clientModel.getFirstName());
        client.setLastName(clientModel.getLastName());
        client.setGender(clientModel.getGender());
        client.setTown(clientModel.getTown());

       return clientRepository.save(client);
    }


    public void deleteClientById(Long id){
        clientRepository.deleteById(id);
    }


}
