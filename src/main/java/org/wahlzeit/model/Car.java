package org.wahlzeit.model;

import org.wahlzeit.services.DataObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.UUID;

/**
 *
 * Car class which holds the properties of the car
 */
public class Car extends DataObject {

    private String brand;

    private String id = null;
    private CarManager manager;
    protected CarType carType;

    /**
     *
     * @methodtype constructor
     */
    public Car(String brand, CarType type) {
        setBrand(brand);
        this.manager = CarManager.getInstance();
        this.carType = type;
        this.id = UUID.randomUUID().toString();
        this.manager.getCars().put(id,this);
    }

    /**
     *
     * @methodtype get
     */
    public String getBrand() {
        return brand;
    }

    /**
     *
     * @methodtype get
     * @return
     */
    public CarType getType() {
        return carType;
    }

    /**
     *
     * @methodtype set
     */
    public void setBrand(String brand) {
        this.brand = brand;
        assertClassInvariants();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(brand, car.brand) && car.getId().equals(this.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand,id);
    }

    protected void assertClassInvariants() {
        if(this.brand == null){
            throw new IllegalStateException("brand must not be null!");
        }
        if(this.brand.isEmpty()){
            throw new IllegalStateException("brand must not be empty");
        }
    }

    public String getId() {
        return id;
    }

    @Override
    public String getIdAsString() {
        return this.id;
    }

    @Override
    public void readFrom(ResultSet rset) throws SQLException {
        assertIsNonNullArgument(rset);
        this.id = rset.getString("id");
        this.brand = rset.getString("brand");
        this.carType = rset.getObject("carType",CarType.class);

    }

    @Override
    public void writeOn(ResultSet rset) throws SQLException {
        assertIsNonNullArgument(rset);
        rset.updateString("id", this.id);
        rset.updateString("brand", this.brand);
        rset.updateObject("carType", this.carType);

    }

    @Override
    public void writeId(PreparedStatement stmt, int pos) throws SQLException {
        assertIsNonNullArgument(stmt);
        assertIsNonNullArgument(pos);
        stmt.setInt(pos, Integer.parseInt(this.id));
    }

    protected void assertIsNonNullArgument(Object c) throws IllegalArgumentException{
        if(c == null)
            throw new IllegalArgumentException("Argument must not be null!");
    }
}
