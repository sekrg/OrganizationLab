package commands;

/**
 * The type Help command.
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

    private final Developer developer;

    public HelpCommand(Developer developer) {
        this.developer = developer;
    }

    @Override
    public String execute() {
        Developer.commandHistory[Developer.commandCounter % 7] = "help";
        Developer.commandCounter++;

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
