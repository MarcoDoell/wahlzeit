package org.wahlzeit.model;

import java.io.File;

public class CarPhotoManager extends PhotoManager {

    public CarPhotoManager() {
        super();
    }

    @Override
    public CarPhoto createPhoto(File file) throws Exception {
        PhotoId id = PhotoId.getNextId();
        CarPhoto result = (CarPhoto) PhotoUtil.createPhoto(file, id);
        addPhoto(result);
        return result;
    }

    @Override
    protected CarPhoto getPhotoFromFilter(PhotoFilter filter) {
        return (CarPhoto) super.getPhotoFromFilter(filter);
    }

    @Override
    protected CarPhoto doGetPhotoFromId(PhotoId id) {
        return (CarPhoto) super.doGetPhotoFromId(id);
    }
}
