package commands;

import collection.DataBase;

/**
 * The type Info command.
 */
public class InfoCommand implements Command {

    @Override
    public String execute() {
        Developer.commandHistory[Developer.commandCounter%7] = "info";
        Developer.commandCounter++;
        return "класс коллекции: "+ DataBase.getInstance().getDataBase().getClass()+"\nсоздано: " +DataBase.getInstance().getFileCreationDate("org.xml")+"\nэлементов внутри: "+DataBase.getInstance().getDataBase().size();

    }
    @Override
    public String getCommandName() {
        return "info";
    }
}