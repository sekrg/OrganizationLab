package commands;

import collection.DataBase;

import java.util.Scanner;

public class UpdateIDCommand implements Command {

    @Override
    public String execute() {
        Developer.commandHistory[Developer.commandCounter%7] = "update_id";
        Developer.commandCounter++;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id");
        int x = scanner.nextInt();
        DataBase.getInstance().updateById(x);
        return "Element updated";
    }
    @Override
    public String getCommandName() {
        return "update_id";
    }
}
