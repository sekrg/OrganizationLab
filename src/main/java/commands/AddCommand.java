package commands;

import utils.Utilities;
import collection.DataBase;


/**
 * The type Add command.
 * Добавляет новую организацию в коллекцию
 */
public class AddCommand implements Command {

    @Override
    public String execute(String[] args) {
        Developer.commandHistory[Developer.commandCounter%7] = "add";
        Developer.commandCounter++;
        DataBase.getInstance().add(Utilities.readOrganization());
        return "Element added";
    }

    @Override
    public String getCommandName() {
        return "add";
    }

    @Override
    public String getCommandDescription() {
        return "добавить новый элемент в коллекцию";
    }
}

