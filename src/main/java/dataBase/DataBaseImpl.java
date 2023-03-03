package dataBase;

import model.Organization;

import java.util.Vector;

public interface DataBaseImpl {

    Vector<Organization> getDataBase();
    void save();

}
