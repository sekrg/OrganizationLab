package commands;

import java.io.IOException;
import java.util.List;

public class Developer {
    public static int commandCounter;
    /**история команд*/
    public static String[] commandHistory = {null, null, null, null, null, null, null};
    private List<Command> commands = List.of(new AddCommand(), new AddIfMinCommand(), new AverageCommand(), new ClearCommand(), new CountCommand(), new ExecuteCommand(), new FilterCommand(), new HelpCommand(), new HistoryCommand(), new InfoCommand(), new RemoveByIdCommand(), new SaveCommand(), new ShowCommand(), new ShuffleCommand(), new UpdateIDCommand());
    static int script_rec = 0;

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
}
