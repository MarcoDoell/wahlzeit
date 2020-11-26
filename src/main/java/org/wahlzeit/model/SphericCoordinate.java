package org.wahlzeit.model;


/**
 *
 * Sperhic Coordinate class
 */
public class SphericCoordinate extends AbstractCoordinate {


    private Double phi;
    private Double theta;
    private Double radius;

    /**
     *
     * @methodtype constructor
     */
    public SphericCoordinate(Double phi, Double theta, Double radius){
        this.phi = phi;
        this.theta = theta;
        this.radius = radius;
    }

    /*public SphericCoordinate(String coordinateasString) {

        String[] coordSplit = coordinateasString.split("/");

        this.phi = Double.parseDouble(coordSplit[0]);
        this.theta = Double.parseDouble(coordSplit[1]);
        this.radius = Double.parseDouble(coordSplit[2]);
    }*/

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

    @Override
    public CartesianCoordinate doAsCartesianCoordinate() {
        double x = this.radius * Math.sin(this.phi) * Math.cos(this.theta);
        double y = this.radius * Math.sin(this.phi) * Math.sin(this.theta);
        double z = this.radius * Math.cos(this.phi);

        return new CartesianCoordinate(x, y, z);
    }

    @Override
    public SphericCoordinate doAsSphericCoordinate() {
        return this;
    }
}
