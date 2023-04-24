package commands;

import collection.DataBase;
import model.Organization;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ShuffleCommand implements Command {

    @Override
    public String execute() {
        Developer.commandHistory[Developer.commandCounter%7] = "shuffle";
        Developer.commandCounter++;
      shuffle(DataBase.getInstance().getDataBase());
        return DataBase.getInstance().getDataBase().stream().map(Organization::toString).collect(Collectors.joining());
    }
    public static<T> void shuffle(List<T> list)
    {Random random = new Random();
        for (int i = list.size() - 1; i >= 1; i--)
        {
            int j = random.nextInt(i + 1);

            T obj = list.get(i);
            list.set(i, list.get(j));
            list.set(j, obj);
        }
    }
    @Override
    public String getCommandName() {
        return "shuffle";
    }
}
