package commands;

import collection.DataBase;
import model.OrganizationType;

import java.util.Locale;
import java.util.Scanner;

public class CountCommand implements Command {

    @Override
    public String execute() {
        Developer.commandHistory[Developer.commandCounter%7] = "count";
        Developer.commandCounter++;
Scanner scanner = new Scanner(System.in);
String s = scanner.nextLine();
OrganizationType type = OrganizationType.valueOf(s.toUpperCase(Locale.ENGLISH).trim());
        return ""; //DataBase.getInstance().getDataBase().stream().filter(e -> e.getType()<type);
    }
    @Override
    public String getCommandName() {
        return "count";
    }
}