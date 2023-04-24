package commands;

import collection.DataBase;
import model.Organization;

import java.util.stream.Collectors;

public class ShowCommand implements Command {

    @Override
    public String execute() {
        Developer.commandHistory[Developer.commandCounter%7] = "show";
        Developer.commandCounter++;
        return DataBase.getInstance().getDataBase().stream().map(Organization::toString).collect(Collectors.joining());
    }
    @Override
    public String getCommandName() {
        return "show";
    }
}