package commands.commandList;

import collection.DataBase;
import commands.Command;

/**
 * The type Remove by id command.
 * Удалить элемент из коллекции по его id
 */
public class RemoveByIdCommand implements Command {

    @Override
    public String execute(String[] args) {
        try {
            int x = Integer.parseInt(args[1]);
            DataBase.getInstance().removeById(x);
            return "Element removed";
        } catch (NumberFormatException e){
            return "Id should be number";
        }
    }
    @Override
    public String getCommandName() {
        return "remove_by_id";
    }
    @Override
    public String getCommandDescription() {
        return "удалить элемент из коллекции по его id";
    }
}
