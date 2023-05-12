package commands.commandList;

import commands.Command;
import utils.InputType;
import utils.Utilities;
import collection.DataBase;


/**
 * The type Add command.
 * Добавляет новую организацию в коллекцию
 */
public class AddCommand implements Command {
    private InputType inputType;

    public AddCommand(InputType inputType) {
        this.inputType = inputType;
    }

    @Override
    public String execute(String[] args) {
        if (inputType.equals(InputType.CMD)){
            DataBase.getInstance().add(Utilities.readOrganization());
        } else {
            DataBase.getInstance().add(Utilities.fromStringToOrganization(args[1]));
        }
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

    public InputType getInputType() {
        return inputType;
    }

    public void setInputType(InputType inputType) {
        this.inputType = inputType;
    }
}

