package org.wahlzeit.model;

import java.util.Objects;

/**
 *
 * Coordinate class to save the coordinates of a point
 */
public interface Coordinate {

    public CartesianCoordinate asCartesianCoordinate();

    public Double getCartesianDistance(Coordinate c);

    public SphericCoordinate asSphericCoordinate();

    public Double getCentralAngle(Coordinate c);

    public boolean isEqual(Coordinate c);

}
