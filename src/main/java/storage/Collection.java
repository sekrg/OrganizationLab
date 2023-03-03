package storage;

import model.Organization;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Vector;

public class Collection {
    private final Vector<Organization> collection;
private static Collection INSTANCE;
public static Collection getINSTANCE()  {
    if(INSTANCE == null) {
        INSTANCE = new Collection();
    }
    return INSTANCE;
}
    private Collection() {
        this.collection = new Vector<>();
    }
    public void load(String filename) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse("People.xml");
        InputStreamReader inputStreamReader;
    }
}


