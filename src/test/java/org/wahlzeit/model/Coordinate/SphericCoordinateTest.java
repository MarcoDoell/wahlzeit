package org.wahlzeit.model.Coordinate;

import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.model.Coordinate.CartesianCoordinate;
import org.wahlzeit.model.Coordinate.Coordinate;
import org.wahlzeit.model.Coordinate.SphericCoordinate;

import static org.junit.Assert.*;
import static org.wahlzeit.model.Coordinate.AbstractCoordinate.sphericCoordinateHashMap;
import static org.wahlzeit.model.Coordinate.CartesianCoordinate.createCartesianCoordinate;
import static org.wahlzeit.model.Coordinate.CartesianCoordinate.createCartesianCoordinateFromString;
import static org.wahlzeit.model.Coordinate.SphericCoordinate.createSphericCoordinate;
import static org.wahlzeit.model.Coordinate.SphericCoordinate.createSphericCoordinateFromString;

public class SphericCoordinateTest {

    @Before
    public void cleanUp() {
        sphericCoordinateHashMap.clear();
    }
    @Test
    public void testAsCartesianCoordinate() {
        Coordinate sphericCoord1 = createSphericCoordinate(1.0,1.0,1.0);
        Coordinate cartesianCoord1 = createCartesianCoordinate(0.4546487134128409,0.7080734182735712,0.5403023058681398);

        CartesianCoordinate sphericAsCartesian = sphericCoord1.asCartesianCoordinate();


        assertEquals(sphericAsCartesian,cartesianCoord1);
    }

    @Test
    public void testCreateSphericCoordinate() {
        createSphericCoordinate(1,1,1);
        assertEquals(1,sphericCoordinateHashMap.size());
    }

    @Test
    public void testCreateSphericCoordinateFromString() {
        createCartesianCoordinateFromString("1/1/1");
        assertEquals(1,sphericCoordinateHashMap.size());
    }

    @Test
    public void testCreateSphericCoordinateSameObjects() {
        createSphericCoordinate(1,1,1);
        createSphericCoordinate(1,1,1);
        createSphericCoordinate(1,1,1);
        createSphericCoordinate(1,1,1);
        assertEquals(1,sphericCoordinateHashMap.size());
    }

    @Test
    public void testCreateSphericCoordinateFromStringSameObject() {
        createSphericCoordinateFromString("1/1/1");
        createSphericCoordinateFromString("1/1/1");
        createSphericCoordinateFromString("1/1/1");
        assertEquals(1,sphericCoordinateHashMap.size());
    }

    @Test
    public void testCreateSphericCoordinateMultipleObjects() {
        createSphericCoordinate(1,1,1);
        createSphericCoordinate(1,1,1);
        createSphericCoordinate(1,1,2);
        createSphericCoordinate(1,2,1);
        assertEquals(3,sphericCoordinateHashMap.size());
    }

    @Test
    public void testCreateSphericCoordinateFromStringMultipleObjects() {
        createSphericCoordinateFromString("1/1/1");
        createSphericCoordinateFromString("1/2/1");
        createSphericCoordinateFromString("1/1/1");
        createSphericCoordinateFromString("1/1/1");
        createSphericCoordinateFromString("3/1/1");
        assertEquals(3,sphericCoordinateHashMap.size());
    }


    @Test(expected = IllegalStateException.class)
    public void testCreatingSphericCoordinateViolatesInvariantsRadius() {
        //Act
        Coordinate coord1 = createSphericCoordinate(1.0,1.0,-1);
    }

    @Test(expected = IllegalStateException.class)
    public void testCreatingSphericCoordinateViolatesInvariantsParameterPhi() {
        //Act
        Coordinate coord1 = createSphericCoordinate(Double.NaN,1.0,1);
    }

    @Test(expected = IllegalStateException.class)
    public void testCreatingSphericCoordinateViolatesInvariantsParameterTheta() {
        //Act
        Coordinate coord1 = createSphericCoordinate(1.0,Double.NaN,1);
    }

    @Test(expected = IllegalStateException.class)
    public void testCreatingSphericCoordinateViolatesInvariantsRadius2() {
        //Act
        Coordinate coord1 = createSphericCoordinate(1.0,1.0,Double.NaN);
    }

    @Test(expected = IllegalStateException.class)
    public void testCreatingSphericCoordinateViolatesInvariantsPhiTooBig() {
        //Act
        Coordinate coord1 = createSphericCoordinate(Math.PI * 5,1.0,1);
    }

    @Test(expected = IllegalStateException.class)
    public void testCreatingSphericCoordinateViolatesInvariantsPhiTooSmall() {
        //Act
        Coordinate coord1 = createSphericCoordinate(-1,1.0,1);
    }

    @Test(expected = IllegalStateException.class)
    public void testCreatingSphericCoordinateViolatesInvariantsThetaTooSmall() {
        //Act
        Coordinate coord1 = createSphericCoordinate(1,-5,1);
    }

    @Test(expected = IllegalStateException.class)
    public void testCreatingSphericCoordinateViolatesInvariantsThetaTooBig() {
        //Act
        Coordinate coord1 = createSphericCoordinate(1,Math.PI * 5,1);
    }

    @Test
    public void testEqualsWorksSameParameters() {
        Coordinate sphericCoord1 = createSphericCoordinate(1.0,1.0,1.0);
        Coordinate sphericCoord2 = createSphericCoordinate(1.0,1.0,1.0);

        assertTrue(sphericCoord1.equals(sphericCoord2));
    }

    @Test
    public void testEqualsWorksSameObject() {
        Coordinate sphericCoord1 = createSphericCoordinate(1.0,1.0,1.0);

        assertTrue(sphericCoord1.equals(sphericCoord1));
    }

    @Test
    public void testEqualsDoesntWorkWrongClass() {
        Coordinate sphericCoord1 = createSphericCoordinate(1.0,1.0,1.0);
        Coordinate sphericCoord2 = createCartesianCoordinate(1.0,1.0,1.0);

        assertFalse(sphericCoord1.equals(sphericCoord2));
    }

    @Test
    public void testEqualsDoesntWorkWrongParameters() {
        Coordinate sphericCoord1 = createSphericCoordinate(1.0,1.0,1.0);
        Coordinate sphericCoord2 = createSphericCoordinate(1.0,1.0,3.0);

        assertFalse(sphericCoord1.equals(sphericCoord2));
    }

    @Test
    public void testEqualsDoesntWorkNull() {
        Coordinate sphericCoord1 = createSphericCoordinate(1.0,1.0,1.0);

        assertFalse(sphericCoord1.equals(null));
    }
}
