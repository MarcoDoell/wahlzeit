package org.wahlzeit.model.Coordinate;

import org.junit.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;

import static org.junit.Assert.assertEquals;

public class AbstractCoordinateTest {


    @Test(expected = IllegalArgumentException.class)
    public void testGetCentralAngleThrowsIllegalArgumentException() {
        //Act
        Coordinate coord1 = new SphericCoordinate(1.0,1.0,1.0);

        //Arrange
        double result = coord1.getCentralAngle(null);
    }

    @Test
    public void testGetCentralAngleWorksWithSpheric() {
        //Act
        Coordinate coord1 = new SphericCoordinate(1.0,1.0,1.0);
        Coordinate coord2 = new SphericCoordinate(0.0,0.0,0.0);

        //Arrange
        double result = coord1.getCentralAngle(coord2);

        //Assert
        assertEquals(1.2745557823062943,result,0.0001);
    }

    @Test
    public void testGetCentralAngleWorksWithCartesian() {
        //Act
        Coordinate coord1 = new CartesianCoordinate(1.0,1.0,1.0);
        Coordinate coord2 = new CartesianCoordinate(2.0,2.0,2.0);

        //Arrange
        double result = coord1.getCentralAngle(coord2);

        //Assert
        assertEquals(0.0,result,0.0001);
    }
    @Test
    public void testGetDistanceWith200to100WithCartesian() {
        //Act
        Coordinate coord1 = new CartesianCoordinate(2,0,0);
        Coordinate coord2 = new CartesianCoordinate(1,0,0);

        //Arrange
        double result = coord1.getCartesianDistance(coord2);

        //Assert
        assertEquals(1,result,0.1);
    }

    @Test
    public void testGetDistanceWithSpheric() {
        //Act
        Coordinate coord1 = new SphericCoordinate(Math.PI,0,0);
        Coordinate coord2 = new SphericCoordinate(Math.PI,0,0);

        //Arrange
        double result = coord1.getCartesianDistance(coord2);

        //Assert
        assertEquals(0,result,0.1);
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
    public void testisEqualworksWithCartesian() {
        //Act
        Coordinate coord1 = new CartesianCoordinate(3.12312312351,0,0);
        Coordinate coord2 = new CartesianCoordinate(3.12312312351,0,0);

        //Arrange
        boolean result = coord1.isEqual(coord2);

        //Assert
        assertEquals(result,true);
    }

    @Test()
    public void testisEqualworksWithSpheric() {
        //Act
        Coordinate coord1 = new SphericCoordinate(3.12312312351,0,0);
        Coordinate coord2 = new SphericCoordinate(3.12312312351,0,0);

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
    public void testisEqualDoesntWorksWithCartesian() {
        //Act
        Coordinate coord1 = new CartesianCoordinate(3.12312312351,0,0);
        Coordinate coord2 = new CartesianCoordinate(3.12352312351,0,0);

        //Arrange
        boolean result = coord1.isEqual(coord2);

        //Assert
        assertEquals(result,false);
    }

    @Test()
    public void testisEqualDoesntWorksWithSpheric() {
        //Act
        Coordinate coord1 = new SphericCoordinate(3.12312312351,3.0,Math.PI);
        Coordinate coord2 = new SphericCoordinate(3.12352312351,1.0,Math.PI);

        //Arrange
        boolean result = coord1.isEqual(coord2);

        //Assert
        assertEquals(false,result);
    }

    @Test()
    public void testEqualsWorksWithCartesian() {
        //Act
        Coordinate coord1 = new CartesianCoordinate(10,12,13);
        Coordinate coord2 = new CartesianCoordinate(10,12,13);

        //Arrange
        boolean result = coord1.equals(coord2);

        //Assert
        assertEquals(result,true);
    }

    @Test()
    public void testEqualsWorksWithSpheric() {
        //Act
        Coordinate coord1 = new SphericCoordinate(0,0,0);
        Coordinate coord2 = new SphericCoordinate(0,0,0);

        //Arrange
        boolean result = coord1.equals(coord2);

        //Assert
        assertEquals(result,true);
    }

    @Test()
    public void testEqualsDoesntWorksWithCartesian() {
        //Act
        Coordinate coord1 = new CartesianCoordinate(1,0,0);
        Coordinate coord2 = new CartesianCoordinate(2,0,0);

        //Arrange
        boolean result = coord1.equals(coord2);

        //Assert
        assertEquals(result,false);
    }

    @Test()
    public void testEqualsDoesntWorksWithSpheric() {
        //Act
        Coordinate coord1 = new SphericCoordinate(3.0,1.0,3.0);
        Coordinate coord2 = new SphericCoordinate(3.0,1.0,Math.PI);

        //Arrange
        boolean result = coord1.equals(coord2);

        //Assert
        assertEquals(result,false);
    }
}
