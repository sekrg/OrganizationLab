package dataBase;

import model.Organization;

import java.util.Vector;

public interface DataBase {

    Vector<Organization> getDataBase();
    void save();

}
