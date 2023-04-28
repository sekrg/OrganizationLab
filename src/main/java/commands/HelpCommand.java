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
    @Override
    public String execute() {
        Developer.commandHistory[Developer.commandCounter%7] = "help";
        Developer.commandCounter++;

        return ANSI_CYAN+"help"+ANSI_RESET+" : вывести справку по доступным командам\n"+
                ANSI_CYAN+"info"+ANSI_RESET+" : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                ANSI_CYAN+"show"+ANSI_RESET+" : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                ANSI_CYAN+"add"+ANSI_RESET+" : добавить новый элемент в коллекцию\n" +
                ANSI_CYAN+"update"+ANSI_RESET+" : обновить значение элемента коллекции, id которого равен заданному\n" +
                ANSI_CYAN+"remove"+ANSI_RESET+" : удалить элемент из коллекции по его id\n" +
                ANSI_CYAN+"clear"+ANSI_RESET+" : : очистить коллекцию\n" +
                ANSI_CYAN+"save"+ANSI_RESET+" : : сохранить коллекцию в файл\n" +
                ANSI_CYAN+"execute"+ANSI_RESET+" : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                ANSI_CYAN+"exit"+ANSI_RESET+" : завершить программу (без сохранения в файл)\n" +
                ANSI_CYAN+"add_if_min"+ANSI_RESET+" : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции\n" +
                ANSI_CYAN+"shuffle"+ANSI_RESET+" : перемешать элементы коллекции в случайном порядке\n" +
                ANSI_CYAN+"history"+ANSI_RESET+" : вывести последние 7 команд (без их аргументов)\n" +
                ANSI_CYAN+"average"+ANSI_RESET+" : вывести среднее значение поля annualTurnover для всех элементов коллекции\n" +
                ANSI_CYAN+"count"+ANSI_RESET+" : вывести количество элементов, значение поля type которых меньше заданного\n" +
                ANSI_CYAN+"filer"+ANSI_RESET+" : вывести элементы, значение поля name которых начинается с заданной подстроки";
    }
    @Override
    public String getCommandName() {
        return "help";
    }

}
