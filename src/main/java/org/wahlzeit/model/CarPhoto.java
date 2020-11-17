package org.wahlzeit.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarPhoto extends Photo {

    public CarPhoto() {
        super();
    }

    public CarPhoto(PhotoId myId) {
        super(myId);
    }

    public CarPhoto(ResultSet rset) throws SQLException {
        super(rset);
    }
}
