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
        this.coordinate = coordinate;
        assertClassInvariants();
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
        this.coordinate = coordinate;
        assertClassInvariants();
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

    public void assertClassInvariants() throws IllegalStateException{
        if(this.getCoordinate() == null)
            throw new IllegalStateException("Coordinate must not be null!");
    }
}
