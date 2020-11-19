package org.wahlzeit.model;

public class Coordinate {

    private double x;
    private double y;
    private double z;

    public Coordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    double getDistance(Coordinate coordinate) {
        if(coordinate == null)
            throw new NullPointerException("Provided coordinate parameter is null");

        double result = Math.sqrt(
                Math.pow((coordinate.getX() - this.getX()), 2) + Math.pow((coordinate.getY() - this.getY()), 2) + Math.pow((coordinate.getZ() - this.getZ()), 2));

        if(result == Double.NaN)
            throw new RuntimeException("Calculations went wrong");

        return result;
    }

    boolean isEqual(Coordinate coordinate) {
        if(coordinate == null)
            throw new NullPointerException("Provided coordinate parameter is null");
        return  Double.compare(coordinate.getX(), this.getX()) == 0 &&
                Double.compare(coordinate.getY(), this.getY()) == 0 &&
                Double.compare(coordinate.getZ(), this.getZ()) == 0;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Coordinate)
            return this.isEqual((Coordinate) o);
        return false;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
}
