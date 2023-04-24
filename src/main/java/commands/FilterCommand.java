package commands;

import collection.DataBase;
import model.Organization;

import java.util.Scanner;
import java.util.stream.Collectors;

public class FilterCommand implements Command {

    @Override
    public String execute() {
        Developer.commandHistory[Developer.commandCounter%7] = "filter";
        Developer.commandCounter++;
Scanner scanner = new Scanner(System.in);
System.out.println("Введите подстроку");
String sub = scanner.nextLine().toUpperCase();
        return DataBase.getInstance().getDataBase().stream().filter(e->e.getName().toUpperCase().contains(sub)).map(Organization::toString).collect(Collectors.joining());
    }
    @Override
    public String getCommandName() {
        return "filter";
    }
}
