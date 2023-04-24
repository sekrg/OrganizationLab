package commands;

public class ExitCommand implements Command {

    @Override
    public String execute() {
        Developer.commandHistory[Developer.commandCounter%7] = "exit";
        Developer.commandCounter++;
        System.exit(1);

        return "finish";
    }
    @Override
    public String getCommandName() {
        return "exit";
    }
}
