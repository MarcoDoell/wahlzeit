package org.wahlzeit.model;

import org.wahlzeit.services.EmailAddress;
import org.wahlzeit.services.Language;
import org.wahlzeit.utils.StringUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarPhoto extends Photo {

    Car car = new Car("Audi");

    public CarPhoto() {
        super();
    }

    public CarPhoto(PhotoId myId) {
        super(myId);
    }

    public CarPhoto(ResultSet rset) throws SQLException {
        super(rset);
    }

    public CarPhoto(Car car) {
        this.car = car;
    }

    @Override
    public void readFrom(ResultSet rset) throws SQLException {
        super.readFrom(rset);
        this.car.setBrand(rset.getString("brand"));
    }

    @Override
    public void writeOn(ResultSet rset) throws SQLException {
        super.writeOn(rset);
        rset.updateString("brand",this.car.getBrand());
    }
}
