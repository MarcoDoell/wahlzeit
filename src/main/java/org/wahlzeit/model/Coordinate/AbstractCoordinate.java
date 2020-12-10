package org.wahlzeit.model.Coordinate;

public abstract class AbstractCoordinate implements Coordinate {


    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return doAsCartesianCoordinate();
    }

    public abstract CartesianCoordinate doAsCartesianCoordinate();


    @Override
    public Double getCartesianDistance(Coordinate c) {
        assertIsNonNullArgument(c);

        CartesianCoordinate thisCoordAsCart = this.asCartesianCoordinate();
        CartesianCoordinate cAsCart = c.asCartesianCoordinate();

        // Calculation
        double result = Math.sqrt(
                Math.pow((cAsCart.getX() - thisCoordAsCart.getX()), 2) + Math.pow((cAsCart.getY() - thisCoordAsCart.getY()), 2) + Math.pow((cAsCart.getZ() - thisCoordAsCart.getZ()), 2));

        if(result == Double.NaN)
            throw new RuntimeException("Calculations went wrong");

        return result;
    }


    @Override
    public SphericCoordinate asSphericCoordinate() {
        return doAsSphericCoordinate();
    }


    public abstract SphericCoordinate doAsSphericCoordinate();

    @Override
    public int hashCode() {
        return doHashCode();
    }
    public abstract int doHashCode();


    @Override
    public Double getCentralAngle(Coordinate c) {
        assertIsNonNullArgument(c);


        SphericCoordinate thisAsSpheric = this.asSphericCoordinate();
        SphericCoordinate cAsSpheric = c.asSphericCoordinate();

        double dtheta = Math.abs(thisAsSpheric.getTheta() - cAsSpheric.getTheta());

        double cos = Math.sin(thisAsSpheric.getPhi()) * Math.sin(cAsSpheric.getPhi()) + Math.cos(thisAsSpheric.getPhi()) * Math.cos(cAsSpheric.getPhi()) * Math.cos(dtheta);

        double result = Math.acos(cos);

        if(Double.isNaN(result))
            throw new ArithmeticException("Calculation returnd a NaN result");

        return result;
    }


    @Override
    public boolean isEqual(Coordinate c) {
        assertIsNonNullArgument(c);

        CartesianCoordinate thisAsCartesian = this.asCartesianCoordinate();
        CartesianCoordinate cAsCartesian = c.asCartesianCoordinate();

        final double THRESHOLD = .0001;

        return Math.abs(cAsCartesian.getX() - thisAsCartesian.getX()) < THRESHOLD &&
                Math.abs(cAsCartesian.getY() - thisAsCartesian.getY()) <THRESHOLD &&
                Math.abs(cAsCartesian.getZ() - thisAsCartesian.getZ()) < THRESHOLD;
    }

    /**
     *
     * compares two coordinates and returns true when both coordinates are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return this.isEqual((Coordinate)o);
    }


    protected void assertIsNonNullArgument(Object c) {
        if(c == null)
            throw new IllegalArgumentException("Argument must not be null!");
    }
}
