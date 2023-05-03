package commands;

import collection.DataBase;

import java.util.Scanner;

/**
 * The type Remove by id command.
 */
public class RemoveByIdCommand implements Command {

    @Override
    public String execute(String[] args) {
        Developer.commandHistory[Developer.commandCounter%7] = "remove_by_id";
        Developer.commandCounter++;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id");
        int x = scanner.nextInt();
        DataBase.getInstance().removeById(x);
        return "Element removed";
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
