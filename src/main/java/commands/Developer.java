package commands;

import java.util.List;

public class Developer {

    private List<Command> commands = List.of(new AddCommand(), new AddIfMinCommand(), new AverageCommand(), new ClearCommand(), new CountCommand(), new ExecuteCommand(), new ExitCommand(), new FilterCommand(), new HelpCommand(), new HistoryCommand(), new InfoCommand(), new RemoveByIdCommand(), new SaveCommand(), new ShowCommand(), new ShuffleCommand(), new UpdateIDCommand());

    public String execute(String line) {

        for (Command command : commands) {
            if(command.getCommandName().equals(line)){
                return command.execute();
            }
        }
        return "Incorrect command";
    }
}
