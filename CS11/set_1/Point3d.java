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
    public double distanceTo(Point3d p1, Point3d p2) {
    	double distance;
    	distance = Math.pow(p1.getX() - p2.getX(), 2) + 
    			   Math.pow(p1.getY() - p2.getY(), 2) + 
    			   Math.pow(p1.getZ() - p2.getZ(), 2);
    	distance = Math.sqrt(distance);

    	return distance;

    }
}

