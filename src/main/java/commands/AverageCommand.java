package commands;

import collection.DataBase;
import model.Organization;

import java.util.stream.Collectors;

/**
 * The type Average command.
 */
public class AverageCommand implements Command {

    @Override
    public String execute() {
        Developer.commandHistory[Developer.commandCounter%7] = "average";
        Developer.commandCounter++;
        return "среднее значение поля annualTurnover для всех элементов коллекции: "+ DataBase.getInstance().getDataBase().stream().mapToLong(Organization::getAnnualTurnover).average().orElse(Double.NaN);
    }
    @Override
    public String getCommandName() {
        return "average";
    }
}
