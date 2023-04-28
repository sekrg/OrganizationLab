package commands;

/**
 * The type History command.
 */
public class HistoryCommand implements Command {

    @Override
    public String execute() {
        System.out.println("Список последних 7 команд: ");
        for (int i=0; i<6; i++){
            System.out.println(Developer.commandHistory[i]);
        }
        Developer.commandHistory[Developer.commandCounter%7] = "history";
        Developer.commandCounter++;
        return "";
    }
    @Override
    public String getCommandName() {
        return "history";
    }
    @Override
    public String getCommandDescription() {
        return "вывести последние 7 команд (без их аргументов)";
    }
}
