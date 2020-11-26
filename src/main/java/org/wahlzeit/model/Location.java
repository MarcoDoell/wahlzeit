package org.wahlzeit.model;

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
    public Location(Coordinate coordinate) {
        if(coordinate == null)
            throw new IllegalArgumentException("Coordinate is not allowed to be null");
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
    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    /**
     *
     * Method to serialize the Location with its property coordinate to save it in datbase
     */
    @Override
    public String toString() {
        CartesianCoordinate tempoCartesianCoordinate = this.coordinate.asCartesianCoordinate();
        return tempoCartesianCoordinate.getX() + "/" + tempoCartesianCoordinate.getY() + "/" + tempoCartesianCoordinate.getZ();
    }
}
