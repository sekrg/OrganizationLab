package commands;

import collection.DataBase;

public class ClearCommand implements Command {

    @Override
    public String execute() {
        Developer.commandHistory[Developer.commandCounter%7] = "clear";
        Developer.commandCounter++;
        DataBase.getInstance().clear();
        return "Collection cleared";
    }
    @Override
    public String getCommandName() {
        return "clear";
    }
}
