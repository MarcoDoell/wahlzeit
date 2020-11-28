package org.wahlzeit.model.Coordinate;

public abstract class AbstractCoordinate implements Coordinate {

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return doAsCartesianCoordinate();
    }

    /**
     *
     * @methodtype helper
     */
    public abstract CartesianCoordinate doAsCartesianCoordinate();

    /**
     *
     * Calculate the distance between 2 coordinates
     */
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


    /**
     *
     * Converts Cartesian into Spheric
     */
    @Override
    public SphericCoordinate asSphericCoordinate() {
        return doAsSphericCoordinate();
    }

    /**
     *
     * @methodtype helper Method that gets implemented in the Classes CartesianCoordinate and SphericCoordinate
     */
    public abstract SphericCoordinate doAsSphericCoordinate();


    /**
     *
     * Calculate the central Angle
     */
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

    /**
     *
     * compares two coordinates and returns true when both coordinates are equal
     */
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

    /**
     *
     * Helper Method for Checking if the Arguments provided are null
     */
    protected void assertIsNonNullArgument(Object c) {
        if(c == null)
            throw new IllegalArgumentException("Argument must not be null!");
    }
}
