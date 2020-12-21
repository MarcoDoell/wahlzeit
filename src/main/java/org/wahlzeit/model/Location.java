package org.wahlzeit.model;

import org.wahlzeit.model.Coordinate.CartesianCoordinate;
import org.wahlzeit.model.Coordinate.Coordinate;
import org.wahlzeit.model.Coordinate.SphericCoordinate;

/**
 * Location class
 */
public class Location {

    /**
     * Coordinates of the location
     */
    protected Coordinate coordinate;

    /**
     *
     * @methodtype constructor
     */
    public Location(Coordinate coordinate) throws IllegalArgumentException {
        assertIsNonNullArgument(coordinate);
        this.coordinate = coordinate;
    }

    /**
     *
     * @methodtype get
     */
    public Coordinate getCoordinate() {
        return this.coordinate;
    }

    /**
     *
     * @methodtype set
     */
    public void setCoordinate(Coordinate coordinate) throws IllegalArgumentException {
        assertIsNonNullArgument(coordinate);
        this.coordinate = coordinate;
    }

    /**
     *
     * Method to serialize the Location with its property coordinate to save it in datbase
     */
    @Override
    public String toString() {
        if(this.coordinate instanceof CartesianCoordinate) {
            CartesianCoordinate tempoCartesianCoordinate = this.coordinate.asCartesianCoordinate();
            return tempoCartesianCoordinate.getX() + "/" + tempoCartesianCoordinate.getY() + "/" + tempoCartesianCoordinate.getZ();
        } else {
            SphericCoordinate tempoSphericCoordinate = this.coordinate.asSphericCoordinate();
            return tempoSphericCoordinate.getPhi() + "/" + tempoSphericCoordinate.getRadius() + "/" + tempoSphericCoordinate.getTheta();
        }
    }

    protected void assertIsNonNullArgument(Object c) throws IllegalArgumentException {
        if(c == null)
            throw new IllegalArgumentException("Argument must not be null!");
    }
}
