package org.wahlzeit.model;

import org.wahlzeit.services.EmailAddress;
import org.wahlzeit.services.Language;
import org.wahlzeit.utils.StringUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * CarPhoto class
 */
@PatternInstance(
        patternName = "Abstract Factory",
        participants = {
                "CarPhoto", "CarPhotoFactory"
        }
)
public class CarPhoto extends Photo {

    Car car = new Car("Audi");

    /**
     *
     * @methodtype constuctor
     */
    public CarPhoto() {
        super();
    }

    /**
     *
     * @methodtype constuctor
     */
    public CarPhoto(PhotoId myId) {
        super(myId);
    }

    /**
     *
     * @methodtype constuctor
     */
    public CarPhoto(ResultSet rset) throws SQLException {
        super(rset);
    }

    /**
     *
     * @methodtype constuctor
     */
    public CarPhoto(Car car) {
        setCar(car);
    }

    /**
     *
     * @methodtype get
     */
    public Car getCar() {
        return car;
    }

    /**
     *
     * @methodtype set
     */
    public void setCar(Car car) {
        this.car = car;
        assertClassInvariants();
    }

    /**
     *
     *
     */
    @Override
    public void readFrom(ResultSet rset) throws SQLException, IllegalStateException {
        super.readFrom(rset);
        this.car = new Car(rset.getString("brand"));
        assertClassInvariants();
    }

    /**
     *
     *
     */
    @Override
    public void writeOn(ResultSet rset) throws SQLException {
        super.writeOn(rset);
        rset.updateString("brand",this.car.getBrand());
    }

    public void assertClassInvariants() throws IllegalStateException{
        if(this.getCar() == null)
            throw new IllegalStateException("Car must not be null!");
    }
}
