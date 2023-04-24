package commands;

import Utils.Utilities;
import collection.DataBase;


public class AddCommand implements Command {

    @Override
    public String execute() {
        Developer.commandHistory[Developer.commandCounter%7] = "add";
        Developer.commandCounter++;
        DataBase.getInstance().add(Utilities.readOrganization());
        return "Element added";
    }

    @Override
    public String getCommandName() {
        return "add";
    }
}

