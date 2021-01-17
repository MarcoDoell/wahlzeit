package org.wahlzeit.model.Coordinate;

import org.wahlzeit.model.PatternInstance;

import java.util.HashMap;
import java.util.Objects;

import static org.wahlzeit.model.Coordinate.SphericCoordinate.createSphericCoordinate;

@PatternInstance(
        patternName = "Flyweight",
        participants = {
                "AbstractCoordinate", "SphericCoordinate", "CartesianCoordinate"
        }
)
public class CartesianCoordinate extends AbstractCoordinate {
    private final double x;
    private final double y;
    private final double z;

    static final HashMap<Integer, CartesianCoordinate> cartesianCoordinateHashMap = new HashMap<>();
    /**
     *
     * @methodtype constructor
     * @param x, y ,z Coordinates
     */
    private CartesianCoordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;

        assertClassInvariants();
    }

    public static CartesianCoordinate createCartesianCoordinate(double x, double y, double z) {
        CartesianCoordinate cart = new CartesianCoordinate(x, y, z);

        return doCreateCartesianCoordinate(cart);

    }

    public static CartesianCoordinate createCartesianCoordinateFromString(String coordinates) {
        CartesianCoordinate cart = new CartesianCoordinate(coordinates);

        return doCreateCartesianCoordinate(cart);

    }

    private static CartesianCoordinate doCreateCartesianCoordinate(CartesianCoordinate cart) {
        CartesianCoordinate result = null;
        synchronized (cartesianCoordinateHashMap) {
                result = cartesianCoordinateHashMap.get(cart.doHashCode());
                if (result == null) {
                    result = cart;
                    cartesianCoordinateHashMap.put(cart.doHashCode(), cart);
                }
            }
        return result;
    }

    /**
     * Converts the String of Coordinates to X, Y , Z
     * @methodtype constructor
     * @param Coordinates as String
     */
    private CartesianCoordinate(String coordinateasString) {

        String[] coordSplit = coordinateasString.split("/");

        this.x = Double.parseDouble(coordSplit[0]);
        this.y = Double.parseDouble(coordSplit[1]);
        this.z = Double.parseDouble(coordSplit[2]);

        assertClassInvariants();
    }

    /**
     *
     *
     */
    @Override
    public CartesianCoordinate doAsCartesianCoordinate() {
        return this;
    }

    /**
     *
     * Method that converts the Cartesian Coordinate into a Spheric Coordinate
     * @return SphericCoordinate
     */
    @Override
    public SphericCoordinate doAsSphericCoordinate() throws ArithmeticException, IllegalStateException {
        double radius = Math.sqrt(Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2) + Math.pow(this.getZ(), 2));

        assertDivisionWithNull(radius);

        double theta = Math.acos(this.getZ() / radius);

        double phi = 0;
        if(this.getX() > 0) {
            phi = Math.atan(this.getY()/this.getX());

        } else if(this.getX() == 0) {
            phi = Math.signum(this.getY()) * Math.PI / 2;

        } else if(this.getX() < 0 && this.getY() >= 0) {
            phi = Math.atan(this.getY()/this.getX()) + Math.PI;

        } else if(this.getX() < 0 && this.getY() < 0) {
            phi = Math.atan(this.getY()/this.getX()) - Math.PI;
        }


        return createSphericCoordinate(phi, theta, radius);
    }

    /**
     *
     * Checks Class Invariants
     */
    @Override
    public void assertClassInvariants() throws IllegalStateException {
        if(Double.isNaN(this.getX())) {
            throw new IllegalStateException("X must not be Nan!");
        }
        if(Double.isNaN(this.getY())) {
            throw new IllegalStateException("Y must not be Nan!");
        }
        if(Double.isNaN(this.getZ())) {
            throw new IllegalStateException("Z must not be Nan!");
        }
    }

    /**
     *
     * Checks Radius is zero
     */
    public void assertDivisionWithNull(double value) throws ArithmeticException {
        if(value == 0) {
            throw new ArithmeticException("Division through zero is not allowed");
        }
    }

    /**
     *
     * hashCode for Cartesian coordinates
     * @return int
     */
    @Override
    public int doHashCode() {
        return Objects.hash(x*HASH_MULTIPLIER, y*HASH_MULTIPLIER, z*HASH_MULTIPLIER);
    }

    /**
     *
     * @methodtype get
     */
    public double getX() {
        return x;
    }

    /**
     *
     * @methodtype set
     */
    public CartesianCoordinate setX(double x) {
        CartesianCoordinate coord = createCartesianCoordinate(x,this.y, this.z);
        assertClassInvariants();
        return coord;
    }

    /**
     *
     * @methodtype get
     */
    public double getY() {
        return y;
    }

    /**
     *
     * @methodtype set
     */
    public CartesianCoordinate setY(double y) {
        CartesianCoordinate coord = createCartesianCoordinate(this.x,y, this.z);
        assertClassInvariants();
        return coord;
    }

    /**
     *
     * @methodtype get
     */
    public double getZ() {
        return z;
    }

    /**
     *
     * @methodtype set
     */
    public CartesianCoordinate setZ(double z) {
        CartesianCoordinate coord = createCartesianCoordinate(this.x,this.y, z);
        assertClassInvariants();
        return coord;
    }
}
