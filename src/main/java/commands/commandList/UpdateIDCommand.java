package commands.commandList;

import collection.DataBase;
import commands.Command;
import model.Organization;
import utils.InputType;
import utils.Utilities;

import java.util.Scanner;

/**
 * The type Update id command.
 * Обновляет значение элемента коллекции, id которого равен заданному
 */
public class UpdateIDCommand implements Command {


    //Не автоматизированный под скрипт update
    // @Override
    //    public String execute(String[] args) {
    //        try {
    //            int x = Integer.parseInt(args[1]);
    //            for (Organization organization : DataBase.getInstance().getDataBase()) {
    //                if (x == organization.getId()) {
    //                    DataBase.getInstance().updateById(x);
    //                    return "Element updated";
    //                }
    //            }
    //            System.out.println("Введите существующий ID");
    //
    //            return "Element removed";
    //        } catch (NumberFormatException e) {
    //            return "Id should be number";
    //        }
    //    }

    private InputType inputType;
    public UpdateIDCommand(InputType inputType) {
        this.inputType = inputType;
    }

    @Override
    public String execute(String[] args) {
        try {
            int x = Integer.parseInt(args[1]);

            if (inputType.equals(InputType.CMD)){
                for (Organization organization : DataBase.getInstance().getDataBase()) {
                    if (x == organization.getId()) {
                        DataBase.getInstance().updateById(x, Utilities.readOrganization());
                        return "Element updated";
                    }
                }

                System.out.println("Введите существующий ID");
            } else {
                String stringOrg = args[2];
                for (Organization organization : DataBase.getInstance().getDataBase()) {
                    if (x == organization.getId()) {
                        DataBase.getInstance().updateById(x, Utilities.fromStringToOrganization(stringOrg));
                        return "Element updated";
                    }
                }
                System.out.println("Введите существующий ID");
            }



            return "Updated.";
        } catch (NumberFormatException e) {
            return "Id should be number";
        }
    }
    @Override
    public String getCommandName() {
        return "update";
    }
    @Override
    public String getCommandDescription() {
        return "обновить значение элемента коллекции, id которого равен заданному";
    }
}
