package org.wahlzeit.model.Coordinate;

/**
 *
 * Coordinate class to save the coordinates of a point
 */
public interface Coordinate {

    public CartesianCoordinate asCartesianCoordinate();

    public Double getCartesianDistance(Coordinate c) throws IllegalArgumentException, ArithmeticException;

    public SphericCoordinate asSphericCoordinate();

    public Double getCentralAngle(Coordinate c) throws IllegalArgumentException, ArithmeticException    ;

    public boolean isEqual(Coordinate c);

}
