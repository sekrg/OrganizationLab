package dataBase;

import model.Organization;

import java.util.Comparator;
import java.util.Vector;

public class DataBaseImpl implements DataBase {

    private Vector<Organization> database;
    private static DataBaseImpl INSTANCE;
    public static DataBaseImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DataBaseImpl();
        }
        return INSTANCE;
    }


    public DataBaseImpl() {
        this.database = new Vector<>();
    }

    public void setDatabase(Vector<Organization> database) {
        this.database = database;
    }
    public void add(Organization organization) {
        organization.setId(generateId());
        database.add(organization);
    }

    private long generateId() {
        Long id = database.stream()
                .map(Organization::getId)
                .max(Comparator.comparing(Long::longValue))
                .orElse(0L);
        return ++id;
    }

    @Override
    public Vector<Organization> getDataBase() {
        return database;
    }

    @Override
    public void save() {

    }
}
