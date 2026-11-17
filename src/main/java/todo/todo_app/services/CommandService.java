package todo.todo_app.services;


import todo.todo_app.models.CommandModel;

import java.util.List;

public interface CommandService {

    List<CommandModel> getAllCommand();
    CommandModel createCommand(CommandModel commandModel);
    CommandModel updateCommandById(Long id, CommandModel commandModel);
    void deleteCommandById(Long id);

}
