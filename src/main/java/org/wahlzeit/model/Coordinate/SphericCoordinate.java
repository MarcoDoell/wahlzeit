package org.wahlzeit.model.Coordinate;


import java.util.Objects;

/**
 *
 * Sperhic Coordinate class
 */
public class SphericCoordinate extends AbstractCoordinate {


    private double phi;
    private double theta;
    private double radius;

    /**
     *
     * @methodtype constructor
     */
    public SphericCoordinate(double phi, double theta, double radius){
        this.phi = phi;
        this.theta = theta;
        this.radius = radius;
    }

    /**
     *
     * @methodtype constructor
     */
    public SphericCoordinate(String coordinateasString) {

        String[] coordSplit = coordinateasString.split("/");

        this.phi = Double.parseDouble(coordSplit[0]);
        this.radius = Double.parseDouble(coordSplit[1]);
        this.theta = Double.parseDouble(coordSplit[2]);
    }

    /**
     *
     * @methodtype get
     */
    public Double getTheta() {
        return theta;
    }

    /**
     *
     * @methodtype set
     */
    public void setTheta(Double theta) {
        this.theta = theta;
    }

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
    public void setRadius(Double radius) {
        this.radius = radius;
    }

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
    public void setPhi(Double phi) {
        this.phi = phi;
    }


    /**
     *
     * Method that converts the Spheric Coordinate into a Cartesian Coordinate
     */
    @Override
    public CartesianCoordinate doAsCartesianCoordinate() {
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
     *
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return this.isEqual((Coordinate)o);
    }

    /**
     *
     * hashCode for coordinates
     */
    @Override
    public int doHashCode() {
        return Objects.hash(phi, theta, radius);
    }
}
