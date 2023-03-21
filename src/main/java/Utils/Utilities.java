package Utils;


import model.Address;
import model.Coordinates;
import model.Organization;
import model.OrganizationType;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class Utilities {
    public static Organization readOrganization() {
        Scanner scanner = new Scanner(System.in);
        Organization organization = new Organization();
        System.out.println("Введите имя организации:");
        organization.setName(getName(scanner));
        System.out.println("Введите координаты организации(2 координаты float, double):");
        organization.setCoordinates(new Coordinates(((int) getId(scanner)), ((double)getId(scanner))));
        organization.setCreationDate(LocalDate.now());
        System.out.println("Введите годовой оборот организации double:");
        organization.setAnnualTurnover(((float) getId(scanner)));
        System.out.println("Введите тип организации(PUBLIC,GOVERNMENT, TRUST, PRIVATE_LIMITED_COMPANY");
        organization.setType(getType(scanner));
        System.out.println("Введите адрес организации(имя и 3 координаты long long float):");
        organization.setOfficialAddress(new Address(getName(scanner)));
        return organization;
    }

    private static long getId(Scanner scanner) {
        while (true) {
            String s = scanner.nextLine();
            try {
                long l = Long.parseLong(s);
                if (l > 0) {
                    return l;
                }
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input!");
            }
        }
    }
    private static OrganizationType getType(Scanner scanner) {
        while (true) {
            String s = scanner.nextLine();
            try{  if (s != null && s.length() > 0) {
                return OrganizationType.valueOf(s.toUpperCase(Locale.ENGLISH).trim());
            }}
            catch (IllegalArgumentException e) {
                System.out.println("Incorrect input!"); }
        }
    }
    private static String getName(Scanner scanner) {
        while (true) {
            String s = scanner.nextLine();
            if (s != null && s.length() > 0) {
                return s;
            }

        }
    }
}