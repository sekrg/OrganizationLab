package commands.list;

import collection.DataBase;
import commands.Command;
import commands.Invoker;
import model.Organization;

import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * The type Filter command.
 * Выводит элементы, значение поля name которых начинается с заданной подстроки
 */
public class FilterCommand implements Command {

    @Override
    public String execute(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите подстроку");
        String sub = scanner.nextLine().toUpperCase();
        return DataBase.getInstance().getDataBase().stream().filter(e->e.getName().toUpperCase().contains(sub)).map(Organization::toString).collect(Collectors.joining());
    }
    @Override
    public String getCommandName() {
        return "filter";
    }

    @Override
    public String getCommandDescription() {
        return "вывести элементы, значение поля name которых начинается с заданной подстроки";
    }
}
