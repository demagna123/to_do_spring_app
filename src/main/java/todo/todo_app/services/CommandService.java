package todo.todo_app.services;


import todo.todo_app.dtos.command.CommandRequestDto;
import todo.todo_app.dtos.command.CommandResponseDto;
import todo.todo_app.models.CommandModel;

import java.util.List;

public interface CommandService {

    List<CommandResponseDto> getAllCommand();
    CommandResponseDto getCommandById(Long id);
    CommandResponseDto createCommand(CommandRequestDto request);
    void deleteCommandById(Long id);

}
