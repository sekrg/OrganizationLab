package ui;

import collection.DataBase;
import collection.ElementsReader;
import commands.Invoker;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import utils.InputType;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * The type Console ui.
 */
public class ConsoleUI {
    private final Scanner scanner;

    /**
     * Instantiates a new Console ui.
     *
     * @param scanner the scanner
     */
    public ConsoleUI(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Start.
     *
     * @throws IOException the io exception
     */
    public void start() throws IOException {

        DataBase dataBase = DataBase.getInstance();

        String filePath = "db";
        System.out.println("Введите help для ознакомления с командами");

        Invoker console = new Invoker(InputType.CMD);

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
            String command = scanner.nextLine();
            if (command.equals("exit")){
                break;
            }
            else {
                System.out.println(console.execute(command));
            }
        }
    }
}
