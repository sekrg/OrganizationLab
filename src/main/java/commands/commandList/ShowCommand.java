package commands.commandList;

import collection.DataBase;
import commands.Command;
import model.Organization;

import java.util.stream.Collectors;

/**
 * The type Show command.
 * Выводит в стандартный поток вывода все элементы коллекции в строковом представлении
 */
public class ShowCommand implements Command {

    @Override
    public String execute(String[] args) {
        return DataBase.getInstance().getDataBase().stream().map(Organization::toString).collect(Collectors.joining("\n"));
    }
    @Override
    public String getCommandName() {
        return "show";
    }
    @Override
    public String getCommandDescription() {
        return "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}