package org.wahlzeit.model.Coordinate;

import org.junit.Test;
import org.wahlzeit.model.Coordinate.CartesianCoordinate;
import org.wahlzeit.model.Coordinate.Coordinate;
import org.wahlzeit.model.Coordinate.SphericCoordinate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class CartesianCoordinateTest {

    @Test
    public void testAsSphericCoordinateY1(){
        Coordinate coord = new CartesianCoordinate(0, 1, 0);

        SphericCoordinate sphericCoordinate = coord.asSphericCoordinate();

        assertTrue(sphericCoordinate.getRadius() == 1);
        assertTrue(sphericCoordinate.getTheta() == Math.PI/2);
        assertTrue(sphericCoordinate.getPhi() == Math.PI/2);
    }


    @Test
    public void testAsSphericCoordinateY1andZ1(){
        Coordinate coord = new CartesianCoordinate(0, 1, 1);

        SphericCoordinate sphericCoordinate = coord.asSphericCoordinate();

        assertTrue(sphericCoordinate.getRadius() == 1.4142135623730951);
        assertTrue(sphericCoordinate.getTheta() == 0.7853981633974483);
        assertTrue(sphericCoordinate.getPhi() == Math.PI/2);
    }

    @Test
    public void testAsSphericCoordinateX2Y3ZMinus1(){
        Coordinate coord = new CartesianCoordinate(2, 3, -1);

        SphericCoordinate sphericCoordinate = coord.asSphericCoordinate();

        assertTrue(sphericCoordinate.getRadius() == 3.7416573867739413);
        assertTrue(sphericCoordinate.getTheta() == 1.6614562139956417);
        assertTrue(sphericCoordinate.getPhi() == 1.387961189801988);
    }

    public void testGetCentralAngleThrowException() {
        //Act
        Coordinate coord1 = new SphericCoordinate(1.0,1.0,1.0);

        //Arrange
        double result = coord1.getCentralAngle(null);
    }

    @Test
    public void testGetCentralAngleWorks() {
        //Act
        Coordinate coord1 = new SphericCoordinate(1.0,1.0,1.0);
        Coordinate coord2 = new SphericCoordinate(0.0,0.0,0.0);

        //Arrange
        double result = coord1.getCentralAngle(coord2);

        //Assert
        assertEquals(1.2745557823062943,result,0.0001);
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
