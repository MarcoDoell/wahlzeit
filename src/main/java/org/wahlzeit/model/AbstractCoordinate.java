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

    @Override
    public Double getCartesianDistance(Coordinate c) {
        return null;
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
