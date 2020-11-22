package org.wahlzeit.model;

import java.util.Objects;

/**
 *
 * Coordinate class to save the coordinates of a point
 */
public class Coordinate {

    private double x;
    private double y;
    private double z;

    /**
     *
     * @methodtype constructor
     */
    public Coordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     *
     * @methodtype constructor
     */
    public Coordinate(String coordinateasString) {

        String[] coordSplit = coordinateasString.split("/");

        this.x = Double.parseDouble(coordSplit[0]);
        this.y = Double.parseDouble(coordSplit[1]);
        this.z = Double.parseDouble(coordSplit[2]);
    }

    /**
     *
     * Calculate the distance between 2 coordinates
     */
    double getDistance(Coordinate coordinate) {
        if(coordinate == null)
            throw new NullPointerException("Provided coordinate parameter is null");

        double result = Math.sqrt(
                Math.pow((coordinate.getX() - this.getX()), 2) + Math.pow((coordinate.getY() - this.getY()), 2) + Math.pow((coordinate.getZ() - this.getZ()), 2));

        if(result == Double.NaN)
            throw new RuntimeException("Calculations went wrong");

        return result;
    }

    /**
     *
     * compares two coordinates and returns true when both coordinates are equal
     */
    boolean isEqual(Coordinate coordinate) {
        final double THRESHOLD = .0001;

        if(coordinate == null)
            throw new NullPointerException("Provided coordinate parameter is null");

        return Math.abs(coordinate.getX() - this.getX()) < THRESHOLD &&
               Math.abs(coordinate.getY() - this.getY()) <THRESHOLD &&
               Math.abs(coordinate.getZ() - this.getZ()) < THRESHOLD;
    }

    /**
     *
     * compares two coordinates and returns true when both coordinates are equal
     */
    @Override
    public boolean equals(Object o) {
        if(o instanceof Coordinate)
            return this.isEqual((Coordinate) o);
        return false;
    }

    /**
     *
     * hashCode for coordinates
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    /**
     *
     * @methodtype get
     */
    public double getX() {
        return x;
    }

    /**
     *
     * @methodtype set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     *
     * @methodtype get
     */
    public double getY() {
        return y;
    }

    /**
     *
     * @methodtype set
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     *
     * @methodtype get
     */
    public double getZ() {
        return z;
    }

    /**
     *
     * @methodtype set
     */
    public void setZ(double z) {
        this.z = z;
    }
}
