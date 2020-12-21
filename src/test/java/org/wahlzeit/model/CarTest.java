package org.wahlzeit.model;

import org.junit.Test;

public class CarTest {

    @Test(expected = IllegalStateException.class)
    public void testCarConstructorWithNullParameter() {
       Car car = new Car(null);
    }

    @Test(expected = IllegalStateException.class)
    public void testCarConstructorWithEmptyParameter() {
        Car car = new Car("");
    }

    @Test
    public void testCarConstructorWithCorrectParameter() {
        Car car = new Car("Hi");
    }
}
