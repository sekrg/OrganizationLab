package commands;

import collection.DataBase;
import model.Organization;

import java.util.Scanner;

/**
 * The type Update id command.
 * Обновляет значение элемента коллекции, id которого равен заданному
 */
public class UpdateIDCommand implements Command {

    @Override
    public String execute(String[] args) {
        Developer.commandHistory[Developer.commandCounter%7] = "update";
        Developer.commandCounter++;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id");
        while(true) {
            int x = scanner.nextInt();
            for(Organization organization : DataBase.getInstance().getDataBase()) {
                if(x == organization.getId()){
                    DataBase.getInstance().updateById(x);
                    return "Element updated";
                }}
            System.out.println("Введите существующий ID");}

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
