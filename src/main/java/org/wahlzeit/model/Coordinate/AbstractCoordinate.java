package org.wahlzeit.model.Coordinate;

import java.util.HashMap;

public abstract class AbstractCoordinate implements Coordinate {


    final static HashMap<Integer, CartesianCoordinate> cartesianCoordinateHashMap = new HashMap<>();
    final static HashMap<Integer, SphericCoordinate> sphericCoordinateHashMap = new HashMap<>();

    /**
     * Converts any Coordinate type to Cartesian Type
     * @return CartesianCoordinate
     */
    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        assertClassInvariants();

        CartesianCoordinate result = doAsCartesianCoordinate();

        assert result != null;

        assertClassInvariants();

        return result;
    }

    public abstract CartesianCoordinate doAsCartesianCoordinate();


    /**
     * Converts any Coordinate type to Spheric Type
     * @return SphericCoordinate
     */
    @Override
    public SphericCoordinate asSphericCoordinate() {
        assertClassInvariants();

        SphericCoordinate result = doAsSphericCoordinate();

        assert result != null;

        assertClassInvariants();

        return result;
    }


    public abstract SphericCoordinate doAsSphericCoordinate();

    @Override
    public int hashCode() {
        return doHashCode();
    }

    public abstract int doHashCode();


    /**
     * Calculates the Cartesian Distance of any Coordinate type
     * @param Coordinate
     * @return Double
     */
    @Override
    public Double getCartesianDistance(Coordinate c) throws IllegalArgumentException, ArithmeticException {
        assertIsNonNullArgument(c);

        CartesianCoordinate thisCoordAsCart = this.asCartesianCoordinate();
        CartesianCoordinate cAsCart = c.asCartesianCoordinate();


        double result = Math.sqrt(
                Math.pow((cAsCart.getX() - thisCoordAsCart.getX()), 2) + Math.pow((cAsCart.getY() - thisCoordAsCart.getY()), 2) + Math.pow((cAsCart.getZ() - thisCoordAsCart.getZ()), 2));

        assertIsValidResult(result);
        assertIsNotNaN(result);

        return result;
    }

    /**
     * Calculates the central angle of any Coordinate type
     * @param Coordinate
     * @return Double
     */
    @Override
    public Double getCentralAngle(Coordinate c) throws IllegalArgumentException, ArithmeticException{
        assertIsNonNullArgument(c);

        SphericCoordinate thisAsSpheric = this.asSphericCoordinate();
        SphericCoordinate cAsSpheric = c.asSphericCoordinate();

        double dtheta = Math.abs(thisAsSpheric.getTheta() - cAsSpheric.getTheta());

        double cos = Math.sin(thisAsSpheric.getPhi()) * Math.sin(cAsSpheric.getPhi()) + Math.cos(thisAsSpheric.getPhi()) * Math.cos(cAsSpheric.getPhi()) * Math.cos(dtheta);

        double result = Math.acos(cos);

        assertIsNotNaN(result);
        assertIsValidResult(result);

        return result;
    }

    /**
     * Compares the provided Coordinate object with the current object and returns true if equal objects
     * @param Coordinate
     * @return boolean
     */
    @Override
    public boolean isEqual(Coordinate c) {
        assertIsNonNullArgument(c);

        CartesianCoordinate thisAsCartesian = this.asCartesianCoordinate();
        CartesianCoordinate cAsCartesian = c.asCartesianCoordinate();

        SphericCoordinate thisAsSpheric = this.asSphericCoordinate();
        SphericCoordinate cAsSpheric = c.asSphericCoordinate();

        final double THRESHOLD = .0001;

        return (Math.abs(cAsCartesian.getX() - thisAsCartesian.getX()) < THRESHOLD &&
                Math.abs(cAsCartesian.getY() - thisAsCartesian.getY()) <THRESHOLD &&
                Math.abs(cAsCartesian.getZ() - thisAsCartesian.getZ()) < THRESHOLD)
                ||
                (Math.abs(thisAsSpheric.getTheta() - cAsSpheric.getTheta()) < THRESHOLD &&
                Math.abs(thisAsSpheric.getPhi() - cAsSpheric.getPhi())  < THRESHOLD &&
                Math.abs(thisAsSpheric.getRadius() - cAsSpheric.getRadius())  < THRESHOLD);
    }

    /**
     * Compares the provided Coordinate object with the current object and returns true if equal objects
     * @param Object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return this.isEqual((Coordinate)o);
    }


    /**
     * assertion method checks if provided parameter is null and throw IllegalArgumentException
     * @param Object
     * @methodtype helper
     */
    protected void assertIsNonNullArgument(Object c) throws IllegalArgumentException{
        if(c == null)
            throw new IllegalArgumentException("Argument must not be null!");
    }

    /**
     * assertion method checks if provided parameter is NaN and throws ArithmeticException
     * @param double
     * @methodtype helper
     */
    protected void assertIsNotNaN(double result) throws ArithmeticException {
        if(Double.isNaN(result))
            throw new ArithmeticException("Calculation return a NaN result");
    }

    protected void assertIsValidResult(double result) throws ArithmeticException {
        if(result < 0) {
            throw new ArithmeticException("Calculation return a value below zero!");
        }
    }

    protected abstract void assertClassInvariants();
}
