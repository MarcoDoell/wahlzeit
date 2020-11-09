package org.wahlzeit.model;

public class Location {

    /**
     * Coordinates of the location
     */
    public Coordinate coordinate;

    public Location(Coordinate coordinate) {
        if(coordinate == null)
            throw new IllegalArgumentException("Coordinate is not allowed to be null");
        this.coordinate = coordinate;
    }
}
