package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test cases for the Coordinate class.
 */
public class CoordinateTest {


    @Test
    public void testGetDistanceWith100() {
        //Act
        Coordinate coord = new Coordinate(1,0,0);

        //Arrange
        double result = coord.getDistance(coord);

        //Assert
        assertEquals(0,result,0.1);
    }

    @Test(expected = NullPointerException.class)
    public void testGetDistanceThrowsException() {
        //Act
        Coordinate coord = new Coordinate(0,0,0);

        //Arrange
        coord.getDistance(null);
    }
}
