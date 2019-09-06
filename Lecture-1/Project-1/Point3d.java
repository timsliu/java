/**
 * Point3d.java
 * 
 * Revision History
 * 02/23/19    Tim Liu    copied from Point2d
 */


/**
 * A three-dimensional point class.
 */
public class Point3d {
    
    /** X coordinate of the point */
    private double xCoord;
    
    /** Y coordinate of the point */
    private double yCoord;

    /** Z coordinate of the point */
    private double zCoord;

    /** Constructor to initialize point to (x, y) value. */
    public Point3d(double x, double y, double z) {
        xCoord = x;
        yCoord = y;
        zCoord = z;
    }

    /** No-argument constructor:  defaults to a point at the origin. */
    public Point3d() {
        // Call three-argument constructor and specify the origin.
        this(0, 0, 0);
    }

    /** Return the X coordinate of the point. */
    public double getX() {
        return xCoord;
    }

    /** Return the Y coordinate of the point. */
    public double getY() {
        return yCoord;
    }

    /** Return the Z coordinate of the point. */
    public double getZ() {
    	return zCoord;
    }

    /** Set the X coordinate of the point. */
    public void setX(double val) {
        xCoord = val;
    }

    /** Set the Y coordinate of the point. */
    public void setY(double val) {
        yCoord = val;
    }

    /** Set the Z coordinate of the point */
    public void setZ(double val) {
    	zCoord = val;
    }

    /** Returns the distance to another Point3d object. */
    public double distanceTo(Point3d p1) {
    	double distance;
    	distance = Math.pow(xCoord - p1.getX(), 2) + 
    			   Math.pow(yCoord - p1.getY(), 2) + 
    			   Math.pow(zCoord - p1.getZ(), 2);
    	distance = Math.sqrt(distance);

    	return distance;

    }

    /** Return whether object is identical to another Point3d object. */
    public boolean equals(Object obj) {
    	if (!(obj instanceof Point3d)) {
    		return false;
    	}

        // typecast generic object to Point3d object
    	Point3d p1 = (Point3d) obj;

    	// check same object type and if each attribute (x, y, z) is the same
    	if (p1.getX() == xCoord && p1.getY() == yCoord && p1.getZ() == zCoord) {
    		return true;
    	}
    	// return false - two objects are not equal
    	return false;
    }
}

