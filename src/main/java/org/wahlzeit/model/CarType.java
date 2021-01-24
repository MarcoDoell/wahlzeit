package org.wahlzeit.model;

import org.wahlzeit.services.DataObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CarType {

    private String typeName;
    protected CarManager manager;
    protected String id = null;
    protected CarType superType = null;
    protected Set<CarType> subTypes = new HashSet<CarType>();

    public CarType(String name) {
        this.typeName = name;
        this.id = UUID.randomUUID().toString();
        this.manager = CarManager.getInstance();
        this.manager.getCarTypes().put(name,this);
    }

    public CarType(String name, Set<CarType> subTypes, CarType superType) {
        this.typeName = name;
        this.id = UUID.randomUUID().toString();
        this.manager = CarManager.getInstance();
        this.subTypes = subTypes;
        this.superType = superType;
        this.manager.getCarTypes().put(name,this);
    }
    public CarType getSuperType() {
        return superType;
    }

    private void setSuperType(CarType carType) {
        this.superType = carType;
    }

    public Iterator<CarType> getSubTypeIterator() {
        return subTypes.iterator();
    }

    public void addSubType(CarType ct) {
        assert (ct != null) :"tried to set null sub-type";
        ct.setSuperType(this);
        subTypes.add(ct);
    }

    public CarManager getManager() {
        return this.manager;
    }

    public boolean hasInstance(Car car) {
        assert (car != null) : "asked about null object";

        if (car.getType() == this) {
            return true;
        }

        for (CarType type : subTypes) {
            if (type.hasInstance(car)) {
                return true;
            }
        }

        return false;
    }

    public boolean isSubtype(CarType type) {
        assert (type != null);

        if (type == this) return true;

        for (CarType t : subTypes) {
            if (t.isSubtype(type))
                return true;
        }
        return false;
    }

    public Car createInstance(String brand) {
        return new Car(brand,this);
    }

    public String getId() {
        return this.id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarType)) return false;
        CarType that = (CarType) o;
        return Objects.equals(getTypeName(), that.getTypeName()) &&
               Objects.equals(getManager(), that.getManager()) &&
               Objects.equals(getSuperType(), that.getSuperType()) &&
               Objects.equals(getSubTypes(), that.getSubTypes());
    }

    private Set<CarType> getSubTypes() {
        return this.subTypes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeName);
    }
}
