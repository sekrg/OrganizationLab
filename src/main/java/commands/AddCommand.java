package commands;

import Utils.Utilities;
import dataBase.DataBaseImpl;


public class AddCommand implements Command {

    @Override
    public String execute() {
        DataBaseImpl.getInstance().add(Utilities.readOrganization());
        return "Element added";
    }

    @Override
    public String getCommandName() {
        return "add";
    }
}

