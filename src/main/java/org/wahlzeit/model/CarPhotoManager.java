package org.wahlzeit.model;



import java.io.File;
import java.util.logging.Logger;

/**
 *
 * CarPhotoManager class for managing CarPhotos
 */
public class CarPhotoManager extends PhotoManager {

    private final static Logger log = Logger.getLogger(CarPhotoManager.class.getName());
    /**
     *
     * @methodtype constructor
     */
    public CarPhotoManager() {
        super();
    }

    /**
     *
     *
     */
    @Override
    public CarPhoto createPhoto(File file) throws Exception {
        assertIsNonNullArgument(file);

        PhotoId id = PhotoId.getNextId();
        CarPhoto result = null;
        try {
             result = (CarPhoto) PhotoUtil.createPhoto(file, id);
        } catch(Exception e) {
            log.severe("CarPhoto could not be created!");
            throw new CreateCarPhotoException("CarPhoto could not be created!",e);
        }
        addPhoto(result);
        return result;
    }

    /**
     *
     *
     */
    @Override
    protected CarPhoto getPhotoFromFilter(PhotoFilter filter) {
        return (CarPhoto) super.getPhotoFromFilter(filter);
    }

    /**
     *
     *
     */
    @Override
    protected CarPhoto doGetPhotoFromId(PhotoId id) {
        return (CarPhoto) super.doGetPhotoFromId(id);
    }

    protected void assertIsNonNullArgument(Object c) throws IllegalArgumentException{
        if(c == null) {
            throw new IllegalArgumentException("Argument must not be null!");
        }
    }
}
