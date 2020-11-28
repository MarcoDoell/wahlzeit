package org.wahlzeit.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(brand, car.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand);
    }
}
