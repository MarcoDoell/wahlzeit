package org.wahlzeit.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;


/**
 *
 * CarPhotoFactory class for creating CarPhotos
 */
@PatternInstance(
        patternName = "Abstract Factory",
        participants = {
                "CarPhoto", "CarPhotoFactory"
        }
)
public class CarPhotoFactory extends PhotoFactory {

    private static final Logger logger = Logger.getLogger(CarPhotoFactory.class.getName());
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
    public CarPhoto createPhoto() throws CreateCarPhotoException {
        CarPhoto carPhoto = null;
        try {
            carPhoto = new CarPhoto();
        } catch(Exception e) {
            logger.severe("photo could not be created!");
            throw new CreateCarPhotoException("photo could not be created!");
        }

        return carPhoto;
    }

    /**
     *
     *
     */
    @Override
    public CarPhoto createPhoto(PhotoId id) throws IllegalArgumentException, CreateCarPhotoException {
        assertIsNonNullArgument(id);
        CarPhoto carPhoto = null;
        try {
            carPhoto = new CarPhoto(id);
        } catch(Exception e) {
            logger.severe("photo could not be created!");
            throw new CreateCarPhotoException("photo could not be created!");
        }

        return carPhoto;
    }

    /**
     *
     *
     */
    @Override
    public CarPhoto createPhoto(ResultSet rs) throws SQLException, IllegalArgumentException, CreateCarPhotoException {
        assertIsNonNullArgument(rs);

        CarPhoto carPhoto = null;
        try {
            carPhoto = new CarPhoto(rs);
        } catch(Exception e) {
            logger.severe("photo could not be created!");
            throw new CreateCarPhotoException("photo could not be created!");
        }

        return carPhoto;
    }

    protected void assertIsNonNullArgument(Object c) throws IllegalArgumentException {
        if(c == null)
            throw new IllegalArgumentException("Argument must not be null!");
    }
}
