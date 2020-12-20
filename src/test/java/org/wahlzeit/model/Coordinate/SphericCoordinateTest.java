package org.wahlzeit.model.Coordinate;

import org.junit.Test;
import org.wahlzeit.model.Coordinate.CartesianCoordinate;
import org.wahlzeit.model.Coordinate.Coordinate;
import org.wahlzeit.model.Coordinate.SphericCoordinate;

import static org.junit.Assert.*;

public class SphericCoordinateTest {

    @Test
    public void testAsCartesianCoordinate() {
        Coordinate sphericCoord1 = new SphericCoordinate(1.0,1.0,1.0);
        Coordinate cartesianCoord1 = new CartesianCoordinate(0.4546487134128409,0.7080734182735712,0.5403023058681398);

        CartesianCoordinate sphericAsCartesian = sphericCoord1.asCartesianCoordinate();


        assertEquals(sphericAsCartesian,cartesianCoord1);
    }

    @Test(expected = AssertionError.class)
    public void testCreatingSphericCoordinateViolatesInvariantsRadius() {
        //Act
        Coordinate coord1 = new SphericCoordinate(1.0,1.0,-1);
    }

    @Test(expected = AssertionError.class)
    public void testCreatingSphericCoordinateViolatesInvariantsParameterPhi() {
        //Act
        Coordinate coord1 = new SphericCoordinate(Double.NaN,1.0,1);
    }

    @Test(expected = AssertionError.class)
    public void testCreatingSphericCoordinateViolatesInvariantsParameterTheta() {
        //Act
        Coordinate coord1 = new SphericCoordinate(1.0,Double.NaN,1);
    }

    @Test(expected = AssertionError.class)
    public void testCreatingSphericCoordinateViolatesInvariantsRadius2() {
        //Act
        Coordinate coord1 = new SphericCoordinate(1.0,1.0,Double.NaN);
    }


    @Test
    public void testEqualsWorksSameParameters() {
        Coordinate sphericCoord1 = new SphericCoordinate(1.0,1.0,1.0);
        Coordinate sphericCoord2 = new SphericCoordinate(1.0,1.0,1.0);

        assertTrue(sphericCoord1.equals(sphericCoord2));
    }

    @Test
    public void testEqualsWorksSameObject() {
        Coordinate sphericCoord1 = new SphericCoordinate(1.0,1.0,1.0);

        assertTrue(sphericCoord1.equals(sphericCoord1));
    }

    @Test
    public void testEqualsDoesntWorkWrongClass() {
        Coordinate sphericCoord1 = new SphericCoordinate(1.0,1.0,1.0);
        Coordinate sphericCoord2 = new CartesianCoordinate(1.0,1.0,1.0);

        assertFalse(sphericCoord1.equals(sphericCoord2));
    }

    @Test
    public void testEqualsDoesntWorkWrongParameters() {
        Coordinate sphericCoord1 = new SphericCoordinate(1.0,1.0,1.0);
        Coordinate sphericCoord2 = new SphericCoordinate(1.0,1.0,3.0);

        assertFalse(sphericCoord1.equals(sphericCoord2));
    }

    @Test
    public void testEqualsDoesntWorkNull() {
        Coordinate sphericCoord1 = new SphericCoordinate(1.0,1.0,1.0);

        assertFalse(sphericCoord1.equals(null));
    }
}
