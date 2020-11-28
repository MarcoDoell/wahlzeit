package org.wahlzeit.model;

import org.junit.Test;
import org.mockito.Mockito;
import org.wahlzeit.model.Coordinate.CartesianCoordinate;
import org.wahlzeit.model.Coordinate.SphericCoordinate;
import org.wahlzeit.services.EmailAddress;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.Mockito.verify;

public class PhotoTest {


    @Test
    public void testReadFrom() throws SQLException {
        //Arrange
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.when(resultSet.getString("location")).thenReturn("1.0/2.0/3.0");
        Mockito.when(resultSet.getString("owner_email_address")).thenReturn("wahlzeit@wahlzeit.de");
        Mockito.when(resultSet.getString("owner_home_page")).thenReturn("http://www.wahlzeit.de");
        Mockito.when(resultSet.getString("coordinateidentifier")).thenReturn("spheric");

        Photo photo = new Photo();

        //Act
        photo.readFrom(resultSet);

        //Assert
        verify(resultSet).getString("location");
        verify(resultSet).getString("coordinateidentifier");
    }


    @Test
    public void testWriteOnWithCartesian() throws SQLException, MalformedURLException {
        //Arrange
        ResultSet resultSet = Mockito.mock(ResultSet.class);

        Photo photo = new Photo();
        photo.setLocation(new Location(new CartesianCoordinate(1,2,3)));
        photo.setOwnerEmailAddress(EmailAddress.getFromString("wahlzeit@wahlzeit.de"));
        photo.setOwnerHomePage(new URL("http://www.wahlzeit.de"));

        //Act
        photo.writeOn(resultSet);

        //Assert
        verify(resultSet).updateString("location",photo.location.toString());
        verify(resultSet).updateString("coordinateidentifier","cartesian");
    }

    @Test
    public void testWriteOnWithSpheric() throws SQLException, MalformedURLException {
        //Arrange
        ResultSet resultSet = Mockito.mock(ResultSet.class);

        Photo photo = new Photo();
        photo.setLocation(new Location(new SphericCoordinate(1.0,2.0,3.0)));
        photo.setOwnerEmailAddress(EmailAddress.getFromString("wahlzeit@wahlzeit.de"));
        photo.setOwnerHomePage(new URL("http://www.wahlzeit.de"));

        //Act
        photo.writeOn(resultSet);

        //Assert
        verify(resultSet).updateString("location",photo.location.toString());
        verify(resultSet).updateString("coordinateidentifier","spheric");
    }
}
