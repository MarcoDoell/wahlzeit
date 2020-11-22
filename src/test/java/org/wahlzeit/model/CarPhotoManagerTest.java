package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CarPhotoManagerTest {

    @Test
    public void testGetInstanceIsACarPhotoManager() {
        //Act & Arrange
        PhotoManager pm = PhotoManager.getInstance();

        //Assert
        assertEquals(pm.getClass(), CarPhotoManager.class);
    }
}
