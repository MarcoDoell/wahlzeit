package org.wahlzeit.model;

import org.junit.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

public class CarTest {

    @Test(expected = IllegalStateException.class)
    public void testCarConstructorWithNullParameter() {
       Car car = new Car(null,null);
    }

    @Test
    public void testCarConstructorWithCorrectParameter() {
        Car car = new Car("Hi", new CarType("ss"));
    }

    @Test
    public void testEquals() {
        Car car = new Car("Hi", new CarType("ss"));
        Car car2 = new Car("Hi", new CarType("ss"));

        assertTrue(car.equals(car2));
    }

    @Test
    public void testReadFrom() throws SQLException {
        //Arrange
        ResultSet resultSet = Mockito.mock(ResultSet.class);

        Car car = new Car("asassas", new CarType("ss"));

        //Act
        car.readFrom(resultSet);

        //Assert
        verify(resultSet).getString("brand");
        verify(resultSet).getString("id");
        verify(resultSet).getObject("carType", CarType.class);
    }

    @Test
    public void testWriteOn() throws SQLException {
        //Arrange
        ResultSet resultSet = Mockito.mock(ResultSet.class);

        Car car = new Car("asassas", new CarType("ss"));

        //Act
        car.writeOn(resultSet);

        //Assert
        verify(resultSet).updateString("brand",car.getId());
        verify(resultSet).updateString("id",car.getBrand());
        verify(resultSet).updateObject("carType", car.getType());
    }
}
