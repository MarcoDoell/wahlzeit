package org.wahlzeit.model;

public class Location {

    /**
     * Coordinates of the location
     */
    protected Coordinate coordinate;

    public Location(Coordinate coordinate) {
        if(coordinate == null)
            throw new IllegalArgumentException("Coordinate is not allowed to be null");
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return this.coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        if(coordinate == null)
            throw new RuntimeException("provided coordinate is null");
        this.coordinate = coordinate;
    }
}
