package commands;

import collection.DataBase;

/**
 * The type Clear command.
 */
public class ClearCommand implements Command {

    @Override
    public String execute(String[] args) {
        Developer.commandHistory[Developer.commandCounter%7] = "clear";
        Developer.commandCounter++;
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
