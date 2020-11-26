package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate {

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return null;
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
        if(c == null)
            throw new NullPointerException("Provided coordinate parameter is null");

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
        return null;
    }

    /**
     *
     * @methodtype helper
     */
    public abstract SphericCoordinate doAsSphericCoordinate();

    @Override
    public Double getCentralAngle(Coordinate c) {
        return null;
    }

    @Override
    public boolean isEqual(Coordinate c) {
        return false;
    }
}
