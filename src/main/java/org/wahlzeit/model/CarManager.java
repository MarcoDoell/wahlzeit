package org.wahlzeit.model;

import org.wahlzeit.services.ObjectManager;
import org.wahlzeit.services.Persistent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CarManager extends ObjectManager {

    protected Map<String, Car> cars = new HashMap<String, Car>();
    protected Map<String, CarType> carTypes = new HashMap<String, CarType>();
    protected static CarManager instance = null;

    public CarManager() {

    }

    public static CarManager getInstance() {
        if (instance == null) {
            instance = new CarManager();
        }
        return instance;
    }

    public Car createCar(String typeName, String brand) {
        assertIsValidCarTypeName(typeName);
        CarType ct = getCarType(typeName);
        Car result = ct.createInstance(brand);
        cars.put(result.getId(), result);
        return result;
    }

    public Car getCar(String id) {
        return cars.get(id);
    }

    public Map<String, Car> getCars() {
        return this.cars;
    }

    private CarType getCarType(String typeName) {
        return carTypes.get(typeName);
    }

    private void assertIsValidCarTypeName(String typeName) {
        if(!carTypes.containsKey(typeName))
            throw new AssertionError("It is not allowed to have the same Cartype Name!");
    }

    @Override
    protected Persistent createObject(ResultSet rset) throws SQLException, CreateCarPhotoException {
        String typename = rset.getObject("carType", CarType.class).getTypeName();
        String brand = rset.getString("brand");
        return createCar(brand,typename);
    }
}
