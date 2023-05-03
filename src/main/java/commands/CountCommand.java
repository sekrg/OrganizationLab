package commands;

import collection.DataBase;
import model.Organization;
import model.OrganizationType;

import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * The type Count command.
 */
public class CountCommand implements Command {

    /**
     * Нельзя конкретно реализовать т.к Type у организаций невозможно сравнить между собой по имени.
     */

    @Override
    public String execute(String[] args) {
        Developer.commandHistory[Developer.commandCounter%7] = "count";
        Developer.commandCounter++;
        System.out.println("Введите тип");
        Scanner scanner = new Scanner(System.in);
        OrganizationType type = getType(scanner);
        return DataBase.getInstance().getDataBase().stream().filter(e -> e.getType().getI()<type.getI()).map(Organization::toString).collect(Collectors.joining()).isEmpty() ? "нет типов меньше заданного" : DataBase.getInstance().getDataBase().stream().filter(e -> e.getType().getI()<type.getI()).map(Organization::toString).collect(Collectors.joining())+"\nКоличество элементов: "+DataBase.getInstance().getDataBase().stream().filter(e -> e.getType().getI()<type.getI()).count();
    }
    private static OrganizationType getType(Scanner scanner) {
        while (true) {
            String s = scanner.nextLine();
            try{  if (s != null && s.length() > 0) {
                return OrganizationType.valueOf(s.toUpperCase(Locale.ENGLISH).trim());
            }}
            catch (IllegalArgumentException e) {
                System.out.println("Incorrect input!"); }
        }
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