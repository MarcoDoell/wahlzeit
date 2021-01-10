package org.wahlzeit.model.Coordinate;

import org.junit.Test;
import org.wahlzeit.model.Coordinate.CartesianCoordinate;
import org.wahlzeit.model.Coordinate.Coordinate;
import org.wahlzeit.model.Coordinate.SphericCoordinate;

import static org.junit.Assert.assertEquals;
import static org.wahlzeit.model.Coordinate.CartesianCoordinate.createCartesianCoordinate;


public class CartesianCoordinateTest {

    @Test
    public void testAsSphericCoordinateY1(){
        Coordinate coord = createCartesianCoordinate(0, 1, 0);

        SphericCoordinate sphericCoordinate = coord.asSphericCoordinate();

        assertEquals(1,sphericCoordinate.getRadius(),0.0001);
        assertEquals(Math.PI/2,(double) sphericCoordinate.getTheta(),0.0001);
        assertEquals(Math.PI/2,(double) sphericCoordinate.getPhi(),0.0001);
    }


    @Test
    public void testAsSphericCoordinateY1andZ1(){
        Coordinate coord = createCartesianCoordinate(0, 1, 1);

        SphericCoordinate sphericCoordinate = coord.asSphericCoordinate();

        assertEquals(1.4142135623730951,(double)sphericCoordinate.getRadius(),0.0001);
        assertEquals(0.7853981633974483,(double)sphericCoordinate.getTheta(),0.0001);
        assertEquals(Math.PI/2,(double)sphericCoordinate.getPhi(),0.0001);
    }

    @Test
    public void testAsSphericCoordinateX2Y3ZMinus1(){
        Coordinate coord = createCartesianCoordinate(2, 3, -1);

        SphericCoordinate sphericCoordinate = coord.asSphericCoordinate();

        assertEquals(3.7416573867739413,sphericCoordinate.getRadius(),0.0001);
        assertEquals(1.8413460897734695,sphericCoordinate.getTheta(),0.0001);
        assertEquals(0.982793723247329,sphericCoordinate.getPhi(),0.0001);
    }

    @Test(expected = IllegalStateException.class)
    public void testConstructorDoesntAllowBadCartesianInstantiationForZ(){
        Coordinate coord = createCartesianCoordinate(2, 3, Double.NaN);
    }

    @Test(expected = IllegalStateException.class)
    public void testConstructorDoesntAllowBadCartesianInstantiationForY(){
        Coordinate coord = createCartesianCoordinate(2, Double.NaN, 2);
    }

    @Test(expected = IllegalStateException.class)
    public void testConstructorDoesntAllowBadCartesianInstantiationForX(){
        Coordinate coord = createCartesianCoordinate(Double.NaN, 3, 2);
    }



}
