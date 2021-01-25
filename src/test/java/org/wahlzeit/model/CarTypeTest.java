package org.wahlzeit.model;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

public class CarTypeTest {


    @Test
    public void testConstructorWorks() {
        CarType ct = new CarType("test");

        assertEquals(ct.getTypeName(), "test");
        assertNotNull(ct.getManager());
        assertNotNull(ct.getId());
    }

    @Test
    public void testConstructor2Works() {
        CarType ct = new CarType("test", new HashSet<CarType>(), new CarType("ss"));

        assertEquals(ct.getTypeName(), "test");
        assertNotNull(ct.getManager());
        assertNotNull(ct.getId());
        assertNotNull(ct.getSuperType());
        assertNotNull(ct.subTypes);
    }

    @Test
    public void testAddSubType() {
        CarType ct = new CarType("test", new HashSet<CarType>(), new CarType("ss"));
        ct.addSubType(new CarType("1"));
        ct.addSubType(new CarType("2"));

        assertEquals(ct.subTypes.size(),2);
    }

    @Test
    public void testHasInstanceIsPresent() {
        CarType ct = new CarType("test", new HashSet<CarType>(), new CarType("ss"));
        CarType ct2 = new CarType("audi");
        ct.addSubType(ct2);
        Car c1 = new Car("audi",ct2);

        assertTrue(ct.hasInstance(c1));
    }

    @Test
    public void testHasInstanceIsNotPresent() {
        CarType ct = new CarType("test", new HashSet<CarType>(), new CarType("ss"));
        CarType ct2 = new CarType("audi");
        CarType ct3 = new CarType("audi");
        ct.addSubType(ct2);
        Car c1 = new Car("audi",ct3);

        assertFalse(ct.hasInstance(c1));
    }


    @Test
    public void testIsSubTypeIsTrue() {
        CarType ct = new CarType("test", new HashSet<CarType>(), new CarType("ss"));
        CarType ct2 = new CarType("audi");

        ct.addSubType(ct2);
        assertTrue(ct.isSubtype(ct2));
    }


    @Test
    public void testIsSubTypeIsTrueRecursive() {
        CarType ct = new CarType("test", new HashSet<CarType>(), new CarType("ss"));
        CarType ct2 = new CarType("audi");
        CarType ct3 = new CarType("audi");

        ct.addSubType(ct2);
        ct2.addSubType(ct3);
        assertTrue(ct.isSubtype(ct3));
    }

    @Test
    public void testIsSubTypeIsFalse() {
        CarType ct = new CarType("test", new HashSet<CarType>(), new CarType("ss"));
        CarType ct2 = new CarType("audi");
        CarType ct3 = new CarType("audi");

        ct.addSubType(ct2);
        assertFalse(ct.isSubtype(ct3));
    }

    @Test
    public void testForHierarchy() {
        CarType root = new CarType("test");
        CarType underRootLeft = new CarType("audi",new HashSet<>(),root);
        CarType underRootRight = new CarType("right",new HashSet<>(),root);
        CarType leafLeft = new CarType("leaf",new HashSet<>(),underRootLeft);

        root.addSubType(underRootLeft);
        root.addSubType(underRootRight);
        underRootLeft.addSubType(leafLeft);


        assertTrue(root.isSubtype(leafLeft));
        assertTrue(root.isSubtype(underRootLeft));
        assertTrue(root.isSubtype(underRootRight));

        assertTrue(underRootLeft.isSubtype(leafLeft));
        assertFalse(underRootRight.isSubtype(leafLeft));

    }

    @Test
    public void testEqualsDoesntWorks() {
        CarType ct = new CarType("test", new HashSet<CarType>(), new CarType("ss"));
        CarType ct2 = new CarType("audi");

        assertFalse(ct.equals(ct2));
    }

    @Test
    public void testEqualsWorks() {
        CarType ct = new CarType("test");
        CarType ct2 = new CarType("test");


        assertTrue(ct.equals(ct2));
    }
}
