package todo.todo_app.services;

import todo.todo_app.models.ClientModel;

import java.util.List;

public interface ClientService {

    List<ClientModel> getAllClient();
    ClientModel createClient(ClientModel clientModel);
    ClientModel updateClientById(Long id, ClientModel clientModel);
    void deleteClientById(Long id);
}
