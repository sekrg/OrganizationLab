package dataBase;

import model.Organization;

import java.util.Vector;

public class DataBase implements DataBaseImpl {

    private Vector<Organization> database;

    public DataBase(Vector<Organization> database) {
        this.database = database;
    }

    public void setDatabase(Vector<Organization> database) {
        this.database = database;
    }

    @Override
    public Vector<Organization> getDataBase() {
        return database;
    }

    @Override
    public void save() {

    }
}
