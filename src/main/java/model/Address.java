package model;

public class Address {
    private String zipCode; //Поле не может быть null

    public Address(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getZipCode() {
        return zipCode;
    }
}

