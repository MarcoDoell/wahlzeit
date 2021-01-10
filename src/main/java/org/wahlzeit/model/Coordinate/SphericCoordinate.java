package org.wahlzeit.model.Coordinate;


import java.util.Objects;

/**
 *
 * Sperhic Coordinate class
 */
public class SphericCoordinate extends AbstractCoordinate {


    private final double phi;
    private final double theta;
    private final double radius;

    /**
     *
     * @methodtype constructor
     * @param phi, theta ,radius Coordinates
     */
    private SphericCoordinate(double phi, double theta, double radius){
        this.phi = phi;
        this.theta = theta;
        this.radius = radius;

        assertClassInvariants();
    }

    /**
     * Converts the String of Coordinates to Phi, Radius and Theta
     * @methodtype constructor
     * @param Coordinatesas String
     */
    public SphericCoordinate(String coordinateasString) {

        String[] coordSplit = coordinateasString.split("/");

        this.phi = Double.parseDouble(coordSplit[0]);
        this.radius = Double.parseDouble(coordSplit[1]);
        this.theta = Double.parseDouble(coordSplit[2]);

        assertClassInvariants();
    }

    /**
     *
     * @methodtype get
     */
    public Double getTheta() { return theta; }

    /**
     *
     * @methodtype set
     */
    /*public void setTheta(Double theta) {
        this.theta = theta;
        assertClassInvariants();
    }*/

    /**
     *
     * @methodtype get
     */
    public Double getRadius() {
        return radius;
    }

    /**
     *
     * @methodtype set
     */
    /*public void setRadius(Double radius) {
        this.radius = radius;
        assertClassInvariants();
    }*/

    /**
     *
     * @methodtype get
     */
    public Double getPhi() {
        return phi;
    }

    /**
     *
     * @methodtype set
     */
    /*public void setPhi(Double phi) {
        this.phi = phi;
        assertClassInvariants();
    }*/


    /**
     *
     * Method that converts the Spheric Coordinate into a Cartesian Coordinate
     * @return CartesianCoordinate
     */
    @Override
    public CartesianCoordinate doAsCartesianCoordinate() throws IllegalStateException {
        double x = this.radius * Math.sin(this.theta) * Math.cos(this.phi);
        double y = this.radius * Math.sin(this.theta) * Math.sin(this.phi);
        double z = this.radius * Math.cos(this.theta);

        return new CartesianCoordinate(x, y, z);
    }

    /**
     *
     *
     */
    @Override
    public SphericCoordinate doAsSphericCoordinate() {
        return this;
    }

    /**
     *
     * hashCode for coordinates
     * @return int
     */
    @Override
    public int doHashCode() {
        return Objects.hash(phi, theta, radius);
    }

    /**
     *
     *
     */
    @Override
    public void assertClassInvariants() throws IllegalStateException {
        if(Double.isNaN(this.getPhi())) {
            throw new IllegalStateException("phi must be a number!");
        }
        if(Double.isNaN(this.getTheta())) {
            throw new IllegalStateException("theta must be a number!");
        }
        if(Double.isNaN(this.getRadius())) {
            throw new IllegalStateException("radius must be number!");
        }
        if(this.getRadius() < 0) {
            throw new IllegalStateException("radius must not be smaller than zero!");
        }
        if(this.getPhi() > (2 * Math.PI)) {
            throw new IllegalStateException("phi must not be bigger than 2* Pi!");
        }
        if(this.getPhi() < 0) {
            throw new IllegalStateException("phi must not be smaller than zero");
        }
        if(this.getTheta() < 0) {
            throw new IllegalStateException("theta must not be smaller than zero");
        }
        if(this.getTheta() > Math.PI) {
            throw new IllegalStateException("theta must be smaller than Pi");
        }
    }
}
