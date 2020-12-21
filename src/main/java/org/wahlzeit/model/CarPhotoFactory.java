package org.wahlzeit.model;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * CarPhotoFactory class for creating CarPhotos
 */
public class CarPhotoFactory extends PhotoFactory {

    /**
     *
     * @methodtype constructor
     */
    public CarPhotoFactory() {
        super();
    }


    /**
     *
     *
     */
    @Override
    public CarPhoto createPhoto() {
        return new CarPhoto();
    }

    /**
     *
     *
     */
    @Override
    public CarPhoto createPhoto(PhotoId id) throws IllegalArgumentException {
        assertIsNonNullArgument(id);
        return new CarPhoto(id);
    }

    /**
     *
     *
     */
    @Override
    public CarPhoto createPhoto(ResultSet rs) throws SQLException, IllegalArgumentException {
        assertIsNonNullArgument(rs);
        return new CarPhoto(rs);
    }

    protected void assertIsNonNullArgument(Object c) throws IllegalArgumentException {
        if(c == null)
            throw new IllegalArgumentException("Argument must not be null!");
    }
}
