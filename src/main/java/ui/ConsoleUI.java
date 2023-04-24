package ui;

import collection.DataBase;
import collection.ElementsReader;
import commands.Developer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
    private final Scanner scanner;

    public ConsoleUI(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() throws IOException {

        DataBase dataBase = DataBase.getInstance();

        String filePath = "C:\\Users\\mc_ga\\IdeaProjects\\Lab5_125592\\org.xml";
        System.out.println("Введите help для ознакомления с командами");

        Developer console = new Developer();

        List<String[]> list;

        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(filePath);
            Element element = document.getDocumentElement();
            NodeList nodeList = element.getChildNodes(); //первая проверка
            ElementsReader elementsReader = new ElementsReader();
            elementsReader.printElements(nodeList); //конец первой проверки
            list = elementsReader.getList();
            dataBase.initi(list);

        }
        catch (SAXException e){
            System.out.println("Ошибка! Файл не подходит для парсинга xml!");
            System.exit(0);
        } catch (ParserConfigurationException | IOException e) {
            throw new RuntimeException(e);

        }
        while (scanner.hasNextLine()) {
            System.out.println(console.execute(scanner.nextLine()));
        }
    }
}
