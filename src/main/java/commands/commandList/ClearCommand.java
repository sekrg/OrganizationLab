package commands.commandList;

import collection.DataBase;
import commands.Command;

/**
 * The type Clear command.
 * Команда для очистки коллекции.
 */
public class ClearCommand implements Command {

    @Override
    public String execute(String[] args) {
        DataBase.getInstance().clear();
        return "Collection cleared";
    }
    @Override
    public String getCommandName() {
        return "clear";
    }

    @Override
    public String getCommandDescription() {
        return "очистить коллекцию";
    }
}
