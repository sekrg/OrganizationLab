package commands;

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
    private List<Command> commands = List.of(new AddCommand(), new AddIfMinCommand(), new AverageCommand(), new ClearCommand(), new CountCommand(), new ExecuteCommand(), new FilterCommand(), new HelpCommand(this), new HistoryCommand(), new InfoCommand(), new RemoveByIdCommand(), new SaveCommand(), new ShowCommand(), new ShuffleCommand(), new UpdateIDCommand());
    /**
     * The Script rec. for executeScript
     */
    static int script_rec = 0;

    /**
     * Execute string.
     *
     * @param line the line
     * @return the string
     * @throws IOException the io exception
     */
    public String execute(String line) throws IOException {
        try { for (Command command : commands) {
            if (command.getCommandName().equals(line)) {
                if(command.getCommandName().equals("execute_script")) {
                    script_rec += 1;
                }
                return command.execute();
            }
        }}
        catch(NullPointerException e) {}

        return "Incorrect commandName!";
    }

    public List<Command> getCommands() {
        return commands;
    }
}
