package commands;

import commands.commandList.*;
import exceptions.RecursionException;
import utils.HistoryManager;
import utils.InputType;
import utils.ScriptManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Developer.
 */
public class Invoker {
    /**
     * история команд
     */
    private final HistoryManager history = new HistoryManager(7);
    private ScriptManager scriptManager = new ScriptManager(null);
    private List<Command> commands = new ArrayList<>();
    public Invoker(InputType inputType) {
        init(inputType);
    }

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
            if (command.getCommandName().equals(line.trim().split(" ")[0])) {
                try {
                    history.addCommandToHistory(command.getCommandName());
                    return command.execute(line.trim().split(" "));
                } catch (RecursionException e){
                    System.out.println(e.getMessage());
                    scriptManager.clearScripts();
                }
            }
        }
        } catch(NullPointerException e) {}

        return "Incorrect commandName!";
    }

    public void init(InputType inputType){
        commands.clear();
        commands.add(new AddCommand(inputType));
        commands.add(new AddIfMinCommand());
        commands.add(new AverageCommand());
        commands.add(new ClearCommand());
        commands.add(new CountCommand());
        commands.add(new ExecuteCommand(scriptManager));
        commands.add(new FilterCommand());
        commands.add(new HelpCommand(this));
        commands.add(new HistoryCommand(history));
        commands.add(new InfoCommand());
        commands.add(new RemoveByIdCommand());
        commands.add(new SaveCommand());
        commands.add(new ShowCommand());
        commands.add(new ShuffleCommand());
        commands.add(new UpdateIDCommand());
    }

    public List<Command> getCommands() {
        return commands;
    }
}
