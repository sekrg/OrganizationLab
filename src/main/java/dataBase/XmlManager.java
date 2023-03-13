package dataBase;

import model.Address;
import model.Coordinates;
import model.Organization;
import model.OrganizationType;

import java.beans.*;
import java.io.*;
import java.time.LocalDate;
import java.util.Vector;

public class XmlManager {

    private DataBase db;
    public XmlManager(DataBase db) {
        this.db = db;
    }
    private void setLocalDatePersistence(XMLEncoder encoder) throws IOException{
        encoder.setPersistenceDelegate(LocalDate.class,
                new PersistenceDelegate() {
                    @Override
                    protected Expression instantiate(Object localDate, Encoder encdr) {
                        return new Expression(localDate,
                                LocalDate.class,
                                "parse",
                                new Object[]{localDate.toString()});
                    }
                });
    }
    public void saveCollectionToXml(String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        XMLEncoder encoder = new XMLEncoder(fos);
        setLocalDatePersistence(encoder);
        for(Organization org : db.getDataBase()){
            encoder.writeObject(org);
        }
        encoder.close();
        fos.close();
    }

    public Vector<Organization> loadCollectionFromXml(String fileName) throws IOException {
        Vector<Organization> dataBase = new Vector<>();
        FileInputStream fis = new FileInputStream(fileName);
        XMLDecoder decoder = new XMLDecoder(fis);

        Organization org = (Organization) decoder.readObject();
        Organization org2 = (Organization) decoder.readObject();

        decoder.close();
        fis.close();

        dataBase.add(org);
        dataBase.add(org2);
        return dataBase;
    }

    public static void main(String[] args) {
        DataBase db = new DataBaseImpl(new Vector<>());
        XmlManager manager = new XmlManager(db);
        LocalDate creationDate = LocalDate.now();
        Organization organization1 = new Organization(1L, "Х", new Coordinates(1,1d),creationDate, 2.31f, 2, OrganizationType.TRUST, new Address("123123"));
        Organization organization2 = new Organization(1L, "Х2", new Coordinates(1,1d),creationDate, 2.31f, 2, OrganizationType.TRUST, new Address("123123"));
//        Organization organization3 = new Organization(1L, "Х3", new Coordinates(1,1d),creationDate, 2.31f, 2, OrganizationType.TRUST, new Address("123123"));
//        Organization organization4 = new Organization(1L, "Х4", new Coordinates(1,1d),creationDate, 2.31f, 2, OrganizationType.TRUST, new Address("123123"));
//        Organization organization5 = new Organization(1L, "Х5", new Coordinates(1,1d),creationDate, 2.31f, 2, OrganizationType.TRUST, new Address("123123"));

        db.getDataBase().add(organization1);
        db.getDataBase().add(organization2);
//        db.getDataBase().add(organization3);
//        db.getDataBase().add(organization4);
//        db.getDataBase().add(organization5);

        try{
//            manager.saveCollectionToXml("org.xml");
            System.out.println(manager.loadCollectionFromXml("org.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
