package org.wahlzeit.model;


import org.junit.Test;
import org.wahlzeit.model.Coordinate.CartesianCoordinate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.wahlzeit.model.Coordinate.CartesianCoordinate.createCartesianCoordinate;

/**
 * Test cases for the Location class.
 */
public class LocationTest {

    @Test(expected = IllegalStateException.class)
    public void testConstructorWithNullParameter() {
        //Act
        Location location = new Location(null);
    }

    @Test
    public void testConstructorWorks() {
        //Act & Arrange
        Location location = new Location(createCartesianCoordinate(0,0,0));

        //Assert
        assertNotNull(location);
        assertNotNull(location.getCoordinate());
    }

    @Test
    public void testToStringWorks() {
        //Act
        Location loc = new Location(createCartesianCoordinate(1.0,2.0,3.0));

        //Arrange
        String locationToString = loc.toString();

        //Assert
        assertEquals(locationToString,"1.0/2.0/3.0");
    }
}
