package org.wahlzeit.model.Coordinate;

import java.util.Objects;

public class CartesianCoordinate implements Coordinate {
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
    public CartesianCoordinate doAsCartesianCoordinate() {
        return this;
    }

    /**
     *
     * Method that converts the Cartesian Coordinate into a Spheric Coordinate
     */
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

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return doAsCartesianCoordinate();
    }

    @Override
    public Double getCartesianDistance(Coordinate c) {
        assertIsNonNullArgument(c);

        CartesianCoordinate thisCoordAsCart = this.asCartesianCoordinate();
        CartesianCoordinate cAsCart = c.asCartesianCoordinate();

        // Calculation
        double result = Math.sqrt(
                Math.pow((cAsCart.getX() - thisCoordAsCart.getX()), 2) + Math.pow((cAsCart.getY() - thisCoordAsCart.getY()), 2) + Math.pow((cAsCart.getZ() - thisCoordAsCart.getZ()), 2));

        if(result == Double.NaN)
            throw new RuntimeException("Calculations went wrong");

        return result;
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        return doAsSphericCoordinate();
    }

    @Override
    public Double getCentralAngle(Coordinate c) {
        assertIsNonNullArgument(c);


        SphericCoordinate thisAsSpheric = this.asSphericCoordinate();
        SphericCoordinate cAsSpheric = c.asSphericCoordinate();

        double dtheta = Math.abs(thisAsSpheric.getTheta() - cAsSpheric.getTheta());

        double cos = Math.sin(thisAsSpheric.getPhi()) * Math.sin(cAsSpheric.getPhi()) + Math.cos(thisAsSpheric.getPhi()) * Math.cos(cAsSpheric.getPhi()) * Math.cos(dtheta);

        double result = Math.acos(cos);

        if(Double.isNaN(result))
            throw new ArithmeticException("Calculation returnd a NaN result");

        return result;
    }

    @Override
    public boolean isEqual(Coordinate c) {
        assertIsNonNullArgument(c);

        CartesianCoordinate thisAsCartesian = this.asCartesianCoordinate();
        CartesianCoordinate cAsCartesian = c.asCartesianCoordinate();

        final double THRESHOLD = .0001;

        return Math.abs(cAsCartesian.getX() - thisAsCartesian.getX()) < THRESHOLD &&
                Math.abs(cAsCartesian.getY() - thisAsCartesian.getY()) <THRESHOLD &&
                Math.abs(cAsCartesian.getZ() - thisAsCartesian.getZ()) < THRESHOLD;
    }

    protected void assertIsNonNullArgument(Object c) {
        if(c == null)
            throw new IllegalArgumentException("Argument must not be null!");
    }
}
