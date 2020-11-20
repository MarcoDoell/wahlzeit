package org.wahlzeit.model;

import java.util.Objects;

public class Coordinate {

    private double x;
    private double y;
    private double z;

    public Coordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Coordinate(String coordinateasString) {

        String[] coordSplit = coordinateasString.split("/");

        this.x = Double.parseDouble(coordSplit[0]);
        this.y = Double.parseDouble(coordSplit[1]);
        this.z = Double.parseDouble(coordSplit[2]);
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
        final double THRESHOLD = .0001;

        if(coordinate == null)
            throw new NullPointerException("Provided coordinate parameter is null");

        return Math.abs(coordinate.getX() - this.getX()) < THRESHOLD &&
               Math.abs(coordinate.getY() - this.getY()) <THRESHOLD &&
               Math.abs(coordinate.getZ() - this.getZ()) < THRESHOLD;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Coordinate)
            return this.isEqual((Coordinate) o);
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
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
