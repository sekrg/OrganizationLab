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

      while(true) {  Organization org = (Organization) decoder.readObject();



        dataBase.add(org);

        return dataBase;}
    }


}
