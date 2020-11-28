package org.wahlzeit.model.Coordinate;

import org.junit.Test;
import org.wahlzeit.model.Coordinate.CartesianCoordinate;
import org.wahlzeit.model.Coordinate.Coordinate;
import org.wahlzeit.model.Coordinate.SphericCoordinate;

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
}
