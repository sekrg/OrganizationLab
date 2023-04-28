package commands;

import collection.DataBase;
import model.Organization;

import java.util.stream.Collectors;

/**
 * The type Show command.
 */
public class ShowCommand implements Command {

    @Override
    public String execute() {
        Developer.commandHistory[Developer.commandCounter%7] = "show";
        Developer.commandCounter++;
        return DataBase.getInstance().getDataBase().stream().map(Organization::toString).collect(Collectors.joining("\n"));
    }
    @Override
    public String getCommandName() {
        return "show";
    }
}