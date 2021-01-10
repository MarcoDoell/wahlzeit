package org.wahlzeit.model.Coordinate;

import java.util.Objects;

public class CartesianCoordinate extends AbstractCoordinate {
    private final double x;
    private final double y;
    private final double z;

    /**
     *
     * @methodtype constructor
     * @param x, y ,z Coordinates
     */
    private CartesianCoordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;

        assertClassInvariants();
    }

    public static CartesianCoordinate createCartesianCoordinate(double x, double y, double z) {

        CartesianCoordinate cart = new CartesianCoordinate(x, y, z);

        CartesianCoordinate result = cartesianCoordinateHashMap.get(cart.hashCode());

        if(result == null) {
            synchronized (cartesianCoordinateHashMap) {
                result = cartesianCoordinateHashMap.get(cart.hashCode());
                if (result == null) {
                    result = cart;
                    cartesianCoordinateHashMap.put(cart.hashCode(), cart);
                }
            }
        }

        return result;
    }

    /**
     * Converts the String of Coordinates to X, Y , Z
     * @methodtype constructor
     * @param Coordinates as String
     */
    public CartesianCoordinate(String coordinateasString) {

        String[] coordSplit = coordinateasString.split("/");

        this.x = Double.parseDouble(coordSplit[0]);
        this.y = Double.parseDouble(coordSplit[1]);
        this.z = Double.parseDouble(coordSplit[2]);

        assertClassInvariants();
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
     * @return SphericCoordinate
     */
    @Override
    public SphericCoordinate doAsSphericCoordinate() throws ArithmeticException, IllegalStateException {
        double radius = Math.sqrt(Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2) + Math.pow(this.getZ(), 2));

        assertDivisionWithNull(radius);

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
     * Checks Class Invariants
     */
    @Override
    public void assertClassInvariants() throws IllegalStateException {
        if(Double.isNaN(this.getX())) {
            throw new IllegalStateException("X must not be Nan!");
        }
        if(Double.isNaN(this.getY())) {
            throw new IllegalStateException("Y must not be Nan!");
        }
        if(Double.isNaN(this.getZ())) {
            throw new IllegalStateException("Z must not be Nan!");
        }
    }

    /**
     *
     * Checks Radius is zero
     */
    public void assertDivisionWithNull(double value) throws ArithmeticException {
        if(value == 0) {
            throw new ArithmeticException("Division through zero is not allowed");
        }
    }

    /**
     *
     * hashCode for Cartesian coordinates
     * @return int
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
    /*public void setX(double x) {
        this.x = x;
        assertClassInvariants();
    }*/

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
    /*public void setY(double y) {
        this.y = y;
        assertClassInvariants();
    }*/

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
    /*public void setZ(double z) {
        this.z = z;
        assertClassInvariants();
    }*/
}
