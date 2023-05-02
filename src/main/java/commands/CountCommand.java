package commands;

import collection.DataBase;
import model.OrganizationType;

import java.util.Locale;
import java.util.Scanner;

/**
 * The type Count command.
 */
public class CountCommand implements Command {

    /**
     * Нельзя конкретно реализовать т.к Type у организаций невозможно сравнить между собой по имени.
     */

    @Override
    public String execute() {
        Developer.commandHistory[Developer.commandCounter%7] = "count";
        Developer.commandCounter++;
Scanner scanner = new Scanner(System.in);
String s = scanner.nextLine();
OrganizationType type = OrganizationType.valueOf(s.toUpperCase(Locale.ENGLISH).trim());
        return "0"; //DataBase.getInstance().getDataBase().stream().filter(e -> e.getType()<type);
    }
    @Override
    public String getCommandName() {
        return "count";
    }

    @Override
    public String getCommandDescription() {
        return "вывести количество элементов, значение поля type которых меньше заданного";
    }
}