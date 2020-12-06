package org.wahlzeit.model.Coordinate;

import java.util.Objects;

public class CartesianCoordinate extends AbstractCoordinate {
    private double x;
    private double y;
    private double z;

    /**
     *
     * @methodtype constructor
     */
    public CartesianCoordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     *
     * @methodtype constructor
     */
    public CartesianCoordinate(String coordinateasString) {

        String[] coordSplit = coordinateasString.split("/");

        this.x = Double.parseDouble(coordSplit[0]);
        this.y = Double.parseDouble(coordSplit[1]);
        this.z = Double.parseDouble(coordSplit[2]);
    }

    /**
     *
     *
     */
    @Override
    public CartesianCoordinate doAsCartesianCoordinate() {
        return this;
    }

    /**
     *
     * Method that converts the Cartesian Coordinate into a Spheric Coordinate
     */
    @Override
    public SphericCoordinate doAsSphericCoordinate() {
        double radius = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));

        double theta = Math.PI/2 - Math.atan(z / (Math.sqrt(Math.pow(x, 2)) + Math.pow(y, 2)));


        double phi;
        if(y >= 0)
            phi = Math.acos(x / (Math.sqrt(Math.pow(x, 2)) + Math.pow(y, 2)));

        else
            phi = 2 * Math.PI - Math.acos(x / (Math.sqrt(Math.pow(x, 2)) + Math.pow(y, 2)));

        // in case x is 0
        if(Double.isNaN(theta))
            theta = 0;

        return new SphericCoordinate(phi, theta, radius);
    }

    /**
     *
     * compares two coordinates and returns true when both coordinates are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return this.isEqual((Coordinate)o);
    }

    /**
     *
     * hashCode for Cartesian coordinates
     */
    @Override
    public int doHashCode() {
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
