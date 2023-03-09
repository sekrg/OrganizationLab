package dataBase;

import model.Address;
import model.Coordinates;
import model.Organization;
import model.OrganizationType;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Vector;

public class XmlManager {

    private DataBase db;
    public XmlManager(DataBase db) {
        this.db = db;
    }

    private static void saveOrgToXml(Organization organization, File file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        XMLEncoder encoder = new XMLEncoder(fos);
        encoder.writeObject(organization);
        encoder.close();
        fos.close();
    }

    public void saveCollectionToXml() throws IOException {
        File file = new File("org.xml");
        for(Organization org : db.getDataBase()){
            saveOrgToXml(org, file);
        }
    }

    public static void main(String[] args) {
        DataBase db = new DataBaseImpl(new Vector<>());
        XmlManager manager = new XmlManager(db);
        LocalDate creationDate = LocalDate.now();
        Organization organization1 = new Organization(1L, "Х", new Coordinates(1,1d),creationDate, 2.31f, 2, OrganizationType.TRUST, new Address("123123"));
        Organization organization2 = new Organization(1L, "Х2", new Coordinates(1,1d),creationDate, 2.31f, 2, OrganizationType.TRUST, new Address("123123"));
        Organization organization3 = new Organization(1L, "Х3", new Coordinates(1,1d),creationDate, 2.31f, 2, OrganizationType.TRUST, new Address("123123"));
        Organization organization4 = new Organization(1L, "Х4", new Coordinates(1,1d),creationDate, 2.31f, 2, OrganizationType.TRUST, new Address("123123"));
        Organization organization5 = new Organization(1L, "Х5", new Coordinates(1,1d),creationDate, 2.31f, 2, OrganizationType.TRUST, new Address("123123"));

        db.getDataBase().add(organization1);
        db.getDataBase().add(organization2);
        db.getDataBase().add(organization3);
        db.getDataBase().add(organization4);
        db.getDataBase().add(organization5);

        try{
            manager.saveCollectionToXml();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
