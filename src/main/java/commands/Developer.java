package commands;

import exceptions.RecursionException;
import utils.ScriptManager;

import java.io.IOException;
import java.util.List;

/**
 * The type Developer.
 */
public class Developer {
    /**
     * The constant commandCounter.
     */
    public static int commandCounter;
    /**
     * история команд
     */
    public static String[] commandHistory = {null, null, null, null, null, null, null};
    private ScriptManager scriptManager = new ScriptManager(null);
    private List<Command> commands = List.of(new AddCommand(), new AddIfMinCommand(), new AverageCommand(), new ClearCommand(), new CountCommand(), new ExecuteCommand(scriptManager), new FilterCommand(), new HelpCommand(this), new HistoryCommand(), new InfoCommand(), new RemoveByIdCommand(), new SaveCommand(), new ShowCommand(), new ShuffleCommand(), new UpdateIDCommand());

    /**
     * Execute string.
     *
     * @param line the line
     * @return the string
     * @throws IOException the io exception
     */
    public String execute(String line) throws IOException {
        try {
            for (Command command : commands) {
            if (command.getCommandName().equals(line.split(" ")[0])) {
                try {
                    return command.execute(line.split(" "));
                } catch (RecursionException e){
                    System.out.println(e.getMessage());
                    scriptManager.clearScripts();
                }
            }
        }
        } catch(NullPointerException e) {}

        return "Incorrect commandName!";
    }


    public List<Command> getCommands() {
        return commands;
    }
}
