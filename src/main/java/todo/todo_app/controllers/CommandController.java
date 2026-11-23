package todo.todo_app.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import todo.todo_app.dtos.command.CommandRequestDto;
import todo.todo_app.dtos.command.CommandResponseDto;
import todo.todo_app.services.implementions.CommandService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("commands")
public class CommandController {

    private  final CommandService commandService;

    public CommandController (CommandService commandService){
        this.commandService = commandService;
    }

    @GetMapping
    List<CommandResponseDto> getAllCommand(){
        return  commandService.getAllCommand();
    }

    @GetMapping("/{id}")
    public CommandResponseDto getCommandById(@PathVariable Long id) {
        return commandService.getCommandById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommandResponseDto createCommand(@Valid @RequestBody CommandRequestDto request) {
        return commandService.createCommand(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCommandById(@PathVariable Long id) {
        commandService.deleteCommandById(id);
    }
}
