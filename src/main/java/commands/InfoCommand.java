package commands;

import collection.DataBase;

public class InfoCommand implements Command {

    @Override
    public String execute() {
        Developer.commandHistory[Developer.commandCounter%7] = "info";
        Developer.commandCounter++;
        return "класс коллекции: "+ DataBase.getInstance().getDataBase().getClass()+"\nсоздано: " +DataBase.getInstance().getFileCreationDate("Input.json")+"\nэлементов внутри: "+DataBase.getInstance().getDataBase().size();

    }
    @Override
    public String getCommandName() {
        return "info";
    }
}