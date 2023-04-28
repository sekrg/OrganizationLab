package commands;

import collection.DataBase;
import model.Organization;
import java.util.Comparator;
import java.util.Optional;

import static Utils.Utilities.readOrganization;

/**
 * The type Add if min command.
 */
public class AddIfMinCommand implements Command {

    @Override
    public String execute() {
        Developer.commandHistory[Developer.commandCounter%7] = "add_if_min";
        Developer.commandCounter++;
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
}

