package commands;

import collection.DataBase;

/**
 * The type Info command.
 * Выводит в стандартный поток вывода информацию о коллекции
 */
public class InfoCommand implements Command {

    @Override
    public String execute(String[] args) {
        Developer.commandHistory[Developer.commandCounter%7] = "info";
        Developer.commandCounter++;
        return "класс коллекции: "+ DataBase.getInstance().getDataBase().getClass()+"\nсоздано: " +DataBase.getInstance().getFileCreationDate("org.xml")+"\nэлементов внутри: "+DataBase.getInstance().getDataBase().size();

    }
    @Override
    public String getCommandName() {
        return "info";
    }
    @Override
    public String getCommandDescription() {
        return "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }
}