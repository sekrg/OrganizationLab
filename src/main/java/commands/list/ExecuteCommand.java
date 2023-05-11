package commands.list;

import commands.Command;
import commands.Invoker;
import exceptions.RecursionException;
import utils.ScriptManager;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

/**
 * The type Execute command.
 * Выполняет скрипт с файла и избегает рекурсию
 */
public class ExecuteCommand implements Command {
    private final ScriptManager scriptManager;

    public ExecuteCommand(ScriptManager scriptManager) {
        this.scriptManager = scriptManager;
    }

    @Override
    public String execute(String[] args) {
        try {
            String filename = args[1];
            if (!scriptManager.getScripts().contains(filename)) {
                try {
                    InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filename));
                    String script = new BufferedReader(inputStreamReader).lines().collect(Collectors.joining("\n"));
                    String[] commands = script.split("\n");
                    Invoker commandHandler = new Invoker();
                    for (String command : commands) {
                        if (!command.split(" ")[0].equals("execute")) {
                            System.out.println(commandHandler.execute(command));
                        } else {
                            scriptManager.addToScripts(command.split(" ")[1]);
                            if (script.contains(command.split(" ")[1])){
                                throw new RecursionException("Recursion found.");
                            }
                            System.out.println(commandHandler.execute(command));
                        }
                    }

                } catch (IOException e) {
                    return "incorrect filename!";
                }
            } else {
                throw new RecursionException("Recursion found.");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return "need argument";
        }
        return "Script executed!";
    }
    @Override
    public String getCommandName() {
        return "execute";
    }

    @Override
    public String getCommandDescription() {
        return "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме";
    }
}
