package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class CarManagerTest {

    @Before
    public void cleanUp() {
        CarManager cm = CarManager.getInstance();
        cm.cars = new HashMap<>();
    }
    @Test
    public void testCreateCar() {
        CarManager cm = CarManager.getInstance();
        String id = UUID.randomUUID().toString();
        CarType ct = new CarType(id);
        Car c = cm.createCar(id, "brand1");
        assertEquals(cm.getCars().size(),1);
    }
}
