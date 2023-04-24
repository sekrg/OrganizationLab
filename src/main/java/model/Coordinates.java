package model;

public class Coordinates {
    private double x; //Значение поля должно быть больше -527
    private Double y;

    public Coordinates(double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public Coordinates() {
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(Double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}