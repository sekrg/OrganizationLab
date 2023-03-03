package model;

public class Coordinates {
    private int x; //Значение поля должно быть больше -527
    private double y;

    public Coordinates(int x, double y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}