package org.wahlzeit.model;

public class CreateCarPhotoException extends Exception {
    public CreateCarPhotoException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public CreateCarPhotoException(String errorMessage) {
        super(errorMessage);
    }
}
