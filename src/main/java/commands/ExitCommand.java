package commands;

public class ExitCommand implements Command {

    @Override
    public String execute() {

        System.exit(1);

        return "finish";
    }
    @Override
    public String getCommandName() {
        return "exit";
    }
}
