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
    public CarPhoto createPhoto(PhotoId id) {
        return new CarPhoto(id);
    }

    /**
     *
     *
     */
    @Override
    public CarPhoto createPhoto(ResultSet rs) throws SQLException {
        return new CarPhoto(rs);
    }
}
