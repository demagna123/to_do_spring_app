package todo.todo_app.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import todo.todo_app.dtos.command.CommandRequestDto;
import todo.todo_app.dtos.command.CommandResponseDto;
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
    List<CommandResponseDto> getAllCommand(){
        return  commandServiceImplementation.getAllCommand();
    }

    @GetMapping("/{id}")
    public CommandResponseDto getCommandById(@PathVariable Long id) {
        return commandServiceImplementation.getCommandById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommandResponseDto createCommand(@Valid @RequestBody CommandRequestDto request) {
        return commandServiceImplementation.createCommand(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCommandById(@PathVariable Long id) {
        commandServiceImplementation.deleteCommandById(id);
    }
}
