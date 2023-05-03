package commands;

import collection.DataBase;
import model.Organization;

/**
 * The type Average command.
 * Выводит среднее значение поля annualTurnover (Годовой оборот) для всех элементов коллекции
 */
public class AverageCommand implements Command {

    @Override
    public String execute(String[] args) {
        Developer.commandHistory[Developer.commandCounter%7] = "average";
        Developer.commandCounter++;
        return "среднее значение поля annualTurnover для всех элементов коллекции: "+ DataBase.getInstance().getDataBase().stream().mapToLong(Organization::getAnnualTurnover).average().orElse(Double.NaN);
    }
    @Override
    public String getCommandName() {
        return "average";
    }

    @Override
    public String getCommandDescription() {
        return "вывести среднее значение поля annualTurnover для всех элементов коллекции";
    }
}
