package org.wahlzeit.model.Coordinate;


import java.util.Objects;

/**
 *
 * Sperhic Coordinate class
 */
public class SphericCoordinate implements Coordinate {


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
        SphericCoordinate that = (SphericCoordinate) o;
        return Objects.equals(phi, that.phi) &&
                Objects.equals(theta, that.theta) &&
                Objects.equals(radius, that.radius);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phi, theta, radius);
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
