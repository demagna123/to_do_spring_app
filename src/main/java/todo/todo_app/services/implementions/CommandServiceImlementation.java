package todo.todo_app.services.implementions;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import todo.todo_app.models.CommandModel;
import todo.todo_app.repositories.CommandRepository;

import java.util.List;

@Transactional
@Service
public class CommandServiceImplementation {

    private final CommandRepository commandRepository;

    public CommandServiceImplementation(CommandRepository commandRepository){
        this.commandRepository  = commandRepository;
    }


    public List<CommandModel> getAllCommand(){
        return  commandRepository.findAll();
    }


    public CommandModel createCommand(CommandModel commandModel){
        return commandRepository.save(commandModel);
    }

}
