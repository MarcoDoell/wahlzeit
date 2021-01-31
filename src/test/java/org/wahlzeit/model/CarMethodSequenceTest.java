package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CarMethodSequenceTest {

    @Test
    public void testCarPhotoObjectSequence() {
        CarPhotoManager carPhotoManager = (CarPhotoManager) CarPhotoManager.getInstance();
        //carPhotoManager.createPhoto("C:\\Users\\marco\\Pictures");
    }

    @Test
    public void testCarObjectSequence() {
        CarType carType = new CarType("test");
        CarManager carManager = CarManager.getInstance();
        Car car = carManager.createCar("test","test22");

        assertEquals(car.getBrand(),"test22");
        assertEquals(car.carType.getTypeName(),"test");
    }
}
