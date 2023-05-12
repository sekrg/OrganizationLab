package commands.commandList;

import collection.DataBase;
import commands.Command;

/**
 * The type Info command.
 * Выводит в стандартный поток вывода информацию о коллекции
 */
public class InfoCommand implements Command {

    @Override
    public String execute(String[] args) {
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