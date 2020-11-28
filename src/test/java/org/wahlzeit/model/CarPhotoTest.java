package org.wahlzeit.model;

import org.junit.Test;
import org.mockito.Mockito;
import org.wahlzeit.services.EmailAddress;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.Mockito.verify;

public class CarPhotoTest {

    @Test
    public void testWriteOn() throws SQLException, MalformedURLException {
        //Arrange
        ResultSet resultSet = Mockito.mock(ResultSet.class);

        CarPhoto photo = new CarPhoto();
        photo.setLocation(new Location(new CartesianCoordinate(1,2,3)));
        photo.setOwnerEmailAddress(EmailAddress.getFromString("wahlzeit@wahlzeit.de"));
        photo.setOwnerHomePage(new URL("http://www.wahlzeit.de"));

        //Act
        photo.writeOn(resultSet);

        //Assert
        verify(resultSet).updateString("brand","Audi");
    }

    @Test
    public void testReadFrom() throws SQLException {
        //Arrange
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.when(resultSet.getString("location")).thenReturn("1.0/2.0/3.0");
        Mockito.when(resultSet.getString("owner_email_address")).thenReturn("wahlzeit@wahlzeit.de");
        Mockito.when(resultSet.getString("owner_home_page")).thenReturn("http://www.wahlzeit.de");

        CarPhoto photo = new CarPhoto();

        //Act
        photo.readFrom(resultSet);

        //Assert
        verify(resultSet).getString("brand");
    }

}
