package org.wahlzeit.model;


import org.junit.Test;
import org.wahlzeit.model.Coordinate.CartesianCoordinate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
        Location location = new Location(new CartesianCoordinate(0,0,0));

        //Assert
        assertNotNull(location);
        assertNotNull(location.getCoordinate());
    }

    @Test
    public void testToStringWorks() {
        //Act
        Location loc = new Location(new CartesianCoordinate(1.0,2.0,3.0));

        //Arrange
        String locationToString = loc.toString();

        //Assert
        assertEquals(locationToString,"1.0/2.0/3.0");
    }
}
