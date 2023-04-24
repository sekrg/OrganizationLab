import ui.ConsoleUI;

import java.nio.file.NoSuchFileException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsoleUI consoleUI = new ConsoleUI(scanner);
        try {
            consoleUI.start();
        } catch (NoSuchElementException e){
            System.out.println("Программа завершена!!!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
