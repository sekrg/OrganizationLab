import commands.Developer;
import dataBase.DataBase;
import dataBase.DataBaseImpl;
import dataBase.XmlManager;
import model.Address;
import model.Coordinates;
import model.Organization;
import model.OrganizationType;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        DataBase db = new DataBaseImpl();
        XmlManager manager = new XmlManager(db);
        try{

            System.out.println(manager.loadCollectionFromXml("org.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Введите help для ознакомления с командами");

        Developer console = new Developer();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            System.out.println(console.execute(scanner.nextLine()));
        }

    }
}
