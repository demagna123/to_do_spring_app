package todo.todo_app.controllers;

import org.springframework.web.bind.annotation.*;
import todo.todo_app.models.CommandModel;
import todo.todo_app.services.implementions.CommandServiceImplementation;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("commands")
public class CommandController {

    private  final CommandServiceImplementation commandServiceImplementation;

    public CommandController (CommandServiceImplementation commandServiceImplementation){
        this.commandServiceImplementation = commandServiceImplementation;
    }

    @GetMapping
    List<CommandModel> getAllCommand(){
        return  commandServiceImplementation.getAllCommand();
    }


    @PostMapping
   public CommandModel createCommand(CommandModel commandModel){
       return commandServiceImplementation.createCommand(commandModel);
    }
}
