import commands.Developer;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        System.out.println("Введите help для ознакомления с командами");

        Developer console = new Developer();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            System.out.println(console.execute(scanner.nextLine()));
        }

    }
}
