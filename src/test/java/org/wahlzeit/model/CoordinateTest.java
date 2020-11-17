package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test cases for the Coordinate class.
 */
public class CoordinateTest {

    @Test
    public void testGetDistanceWith200to100() {
        //Act
        Coordinate coord1 = new Coordinate(2,0,0);
        Coordinate coord2 = new Coordinate(1,0,0);

        //Arrange
        double result = coord1.getDistance(coord2);

        //Assert
        assertEquals(1,result,0.1);
    }

    @Test(expected = NullPointerException.class)
    public void testGetDistanceThrowsException() {
        //Act
        Coordinate coord1 = new Coordinate(0,0,0);
        Coordinate coord2 = null;

        //Arrange
        coord1.getDistance(coord2);
    }

    @Test()
    public void testisEqualworks() {
        //Act
        Coordinate coord1 = new Coordinate(0,0,0);
        Coordinate coord2 = new Coordinate(0,0,0);

        //Arrange
        boolean result = coord1.equals(coord2);

        //Assert
        assertEquals(result,true);
    }

    @Test()
    public void testisEqualDoesntWorks() {
        //Act
        Coordinate coord1 = new Coordinate(0,0,0);
        Coordinate coord2 = new Coordinate(1,0,0);

        //Arrange
        boolean result = coord1.equals(coord2);

        //Assert
        assertEquals(result,false);
    }

    @Test()
    public void testEqualsWorks() {
        //Act
        Coordinate coord1 = new Coordinate(0,0,0);
        Coordinate coord2 = new Coordinate(0,0,0);

        //Arrange
        boolean result = coord1.equals(coord2);

        //Assert
        assertEquals(result,true);
    }

    @Test()
    public void testEqualsDoesntWorks() {
        //Act
        Coordinate coord1 = new Coordinate(0,0,0);
        Coordinate coord2 = new Coordinate(1,0,0);

        //Arrange
        boolean result = coord1.equals(coord2);

        //Assert
        assertEquals(result,false);
    }
}
