package commands.list;

import commands.Command;
import commands.Invoker;

/**
 * The type Help command.
 * Вывести справку по доступным командам
 */
public class HelpCommand implements Command {
    /**
     * The constant ANSI_RESET.
     */
    public static final String ANSI_RESET = "\u001B[0m";
    /**
     * The constant ANSI_CYAN.
     */
    public static final String ANSI_CYAN = "\u001B[36m";

    private final Invoker developer;

    public HelpCommand(Invoker invoker) {
        this.developer = invoker;
    }

    @Override
    public String execute(String[] args) {

        for (Command o : developer.getCommands()) {
            System.out.println(ANSI_CYAN + o.getCommandName() + ANSI_RESET + " : " + o.getCommandDescription());

        }
        return "";
    }
    @Override
    public String getCommandName() {
        return "help";
    }

    @Override
    public String getCommandDescription() {
        return "вывести справку по доступным командам";
    }

}
