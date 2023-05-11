package commands.list;

import collection.DataBase;
import commands.Command;
import commands.Invoker;
import model.Organization;
import java.util.Comparator;
import java.util.Optional;

import static utils.Utilities.readOrganization;

/**
 * The type Add if min command.
 */
public class AddIfMinCommand implements Command {
    /**
     * Добавляет элемент если значение годового оборота у введенной организации < чем у существующих.
     */
    @Override
    public String execute(String[] args) {
        Organization organization = readOrganization();
        Optional<Organization> minElement = DataBase.getInstance().getDataBase()
                .stream()
                .min(Comparator.comparing(Organization::getAnnualTurnover));
        if (minElement.isPresent()) {
            if (minElement.get().getAnnualTurnover() > organization.getAnnualTurnover()) {
                DataBase.getInstance().add(organization);
                return "Element was added";
            } else {
                return "Current element not a min";
            }
        } else {
            return "No min element in collection!";
        }
    }

    @Override
    public String getCommandName() {
        return "add_if_min";
    }

    @Override
    public String getCommandDescription() {
        return "добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции";
    }
}

