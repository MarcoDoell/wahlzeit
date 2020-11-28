package org.wahlzeit.model.Coordinate;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AbstractCoordinateTest {


    @Test
    public void testGetCentralAngleThrowException() {

    }

    @Test
    public void testGetCentralAngleWorks() {

    }
    @Test
    public void testGetDistanceWith200to100() {
        //Act
        Coordinate coord1 = new CartesianCoordinate(2,0,0);
        Coordinate coord2 = new CartesianCoordinate(1,0,0);

        //Arrange
        double result = coord1.getCartesianDistance(coord2);

        //Assert
        assertEquals(1,result,0.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetDistanceThrowsException() {
        //Act
        Coordinate coord1 = new CartesianCoordinate(0,0,0);
        Coordinate coord2 = null;

        //Arrange
        coord1.getCartesianDistance(coord2);
    }

    @Test()
    public void testisEqualworks() {
        //Act
        Coordinate coord1 = new CartesianCoordinate(3.12312312351,0,0);
        Coordinate coord2 = new CartesianCoordinate(3.12312312351,0,0);

        //Arrange
        boolean result = coord1.isEqual(coord2);

        //Assert
        assertEquals(result,true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testisEqualThrowsNullPointerException() {
        //Act
        Coordinate coord1 = new CartesianCoordinate(0,0,0);

        //Arrange
        boolean result = coord1.isEqual(null);
    }

    @Test()
    public void testisEqualDoesntWorks() {
        //Act
        Coordinate coord1 = new CartesianCoordinate(3.12312312351,0,0);
        Coordinate coord2 = new CartesianCoordinate(3.12352312351,0,0);

        //Arrange
        boolean result = coord1.isEqual(coord2);

        //Assert
        assertEquals(result,false);
    }

    @Test()
    public void testEqualsWorks() {
        //Act
        Coordinate coord1 = new CartesianCoordinate(0,0,0);
        Coordinate coord2 = new CartesianCoordinate(0,0,0);

        //Arrange
        boolean result = coord1.equals(coord2);

        //Assert
        assertEquals(result,true);
    }

    @Test()
    public void testEqualsDoesntWorks() {
        //Act
        Coordinate coord1 = new CartesianCoordinate(0,0,0);
        Coordinate coord2 = new CartesianCoordinate(1,0,0);

        //Arrange
        boolean result = coord1.equals(coord2);

        //Assert
        assertEquals(result,false);
    }
}