package dataBase;

import model.Organization;

import java.util.Vector;

public class DataBaseImpl implements DataBase {

    private Vector<Organization> database;

    public DataBaseImpl(Vector<Organization> database) {
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
