package org.wahlzeit.model;

/**
 *
 * Car class which holds the properties of the car
 */
public class Car {

    private String brand;

    /**
     *
     * @methodtype constructor
     */
    public Car(String brand) {
        this.brand = brand;
    }

    /**
     *
     * @methodtype get
     */
    public String getBrand() {
        return brand;
    }


    /**
     *
     * @methodtype set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }
}
