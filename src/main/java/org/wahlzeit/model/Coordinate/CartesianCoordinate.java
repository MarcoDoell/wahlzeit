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
        double radius = Math.sqrt(Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2) + Math.pow(this.getZ(), 2));

        if(radius == 0)
            throw new ArithmeticException("Radius is zero, cant convert to Spheric");

        double theta = Math.acos(this.getZ() / radius);

        double phi = 0;
        if(this.getX() > 0) {
            phi = Math.atan(this.getY()/this.getX());

        } else if(this.getX() == 0) {
            phi = Math.signum(this.getY()) * Math.PI / 2;

        } else if(this.getX() < 0 && this.getY() >= 0) {
            phi = Math.atan(this.getY()/this.getX()) + Math.PI;

        } else if(this.getX() < 0 && this.getY() < 0) {
            phi = Math.atan(this.getY()/this.getX()) - Math.PI;
        }


        return new SphericCoordinate(phi, theta, radius);
    }

    /**
     *
     *
     */
    @Override
    public void assertClassInvariants() {
        assert !Double.isNaN(this.getX()) && !Double.isNaN(this.getY()) && !Double.isNaN(this.getZ());
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
