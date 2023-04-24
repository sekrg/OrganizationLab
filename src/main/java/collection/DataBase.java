package collection;

import Utils.Utilities;
import model.Address;
import model.Coordinates;
import model.Organization;
import model.OrganizationType;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.*;


public class DataBase {

    private Vector<Organization> database;
    private static DataBase INSTANCE;
    public static DataBase getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DataBase();
        }
        return INSTANCE;
    }


    private DataBase() {
        this.database = new Vector<>();
    }
    public static TreeSet<Integer> idCounter = new TreeSet<>();
    static int id = 1;
    public void setDatabase(Vector<Organization> database) {
        this.database = database;
    }
    public void add(Organization organization) {
        organization.setId(generateId());
        database.add(organization);
    }
    public void removeById(int id) {
        database.removeIf(e -> String.valueOf(e.getId()).equals(String.valueOf(id)));
    }
    public void updateById(int id) {
        database.removeIf(e -> String.valueOf(e.getId()).equals(String.valueOf(id)));
        Organization organization = Utilities.readOrganization();
        organization.setId(id);
        database.add(organization);
    }
    public FileTime getFileCreationDate(String fileName) {
        try {
            return (FileTime) Files.getAttribute((new File(fileName)).toPath(), "creationTime");
        } catch (IOException e) {
            return null;
        }
    }
    private int generateId() {
        int id = database.stream()
                .map(Organization::getId)
                .max(Comparator.comparing(Integer::intValue))
                .orElse(0);
        return ++id;
    }
    public Vector<Organization> getDataBase() {
        return database;
    }
    public void initi(List<String[]> list){
        for (int i = 0; i < list.size(); i++) {
            Address address = new Address();
            Organization organization = new Organization();
            Coordinates coordinates = new Coordinates();

            try {
                System.out.println("PARSING OBJECT № " + (i+1) + "... ");
                if (list.get(i)[0].equals("null") || list.get(i)[0].trim().equals("") || //быстрая проверка на валидность полей
                        list.get(i)[1].equals("null") || list.get(i)[1].trim().equals("") ||
                        list.get(i)[2].equals("null") || list.get(i)[2].trim().equals("") ||
                        list.get(i)[3].equals("null") || list.get(i)[3].trim().equals("") ||
                        list.get(i)[4].equals("null") || list.get(i)[4].trim().equals("") ||
                        list.get(i)[5].equals("null") || list.get(i)[5].trim().equals("") ||
                        list.get(i)[6].equals("null") || list.get(i)[6].trim().equals("") ||
                        list.get(i)[7].equals("null") || list.get(i)[7].trim().equals("")){
                    throw new NullPointerException();
                }

                organization.setName(list.get(i)[0]);

                coordinates.setX(Double.parseDouble(list.get(i)[1]));

                coordinates.setY(Double.valueOf(list.get(i)[2]));

                organization.setCoordinates(coordinates);

                organization.setCreationDate(Date.from(Instant.now()));

                organization.setAnnualTurnover(Long.parseLong(list.get(i)[4]));

                organization.setEmployeesCount(Long.valueOf(list.get(i)[5]));

                organization.setType(OrganizationType.valueOf(list.get(i)[6]));

                address.setZipCode(list.get(i)[7]);
                organization.setOfficialAddress(address);

                while (!idCounter.add(id)) {
                    id++;
                }

                organization.setId(id); //id

                database.add(organization); //добавляем проверенный объект в коллекцию
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Некорректно введены данные. Поля не могут быть не заданы или быть null.");
            }
            catch (DateTimeParseException e0) {
                System.out.println("Некорректно указана дата. Пример ввода даты: \"Mar 23, 2023, 2:51:01 PM\"");
            } catch (EnumConstantNotPresentException e1){
                System.out.println("Некорректно введены данные. Поле Collection.Mood может принимать только значения:\n -SADNESS \n LONGING \nRAGE \n-null");
            } catch (NumberFormatException e2) {
                System.out.println("Некорректно введены данные. Проверьте числовые данные.");
            } catch (IllegalArgumentException e3) {
                System.out.println("Некорректно введены данные. Проверьте корректность логических переменных.");
            } catch (NullPointerException e4) {
                System.out.println("Некорректно введены данные. Поля не могут быть null.\nЧтобы узнать подробную информацию" +
                        " про ограничения на значения полей введите команду: help -a.");
            }

        }
    }
     public void printList(List<String[]> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println("List № " + (i+1) + ": ");
            for (int j = 0; j < 8; j++) {
                System.out.println("Element № " + j + " = " + list.get(i)[j]);
            }
        }
    }
    public void clear() {
        database.clear();
    }
}
