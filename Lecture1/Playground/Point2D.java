 public class Point2d {
    // Coordinates
    private double xCoord;
    private double yCoord;
    /** Two-argument constructor. **/
    public Point2d(double x, double y) {
        xCoord = x;
        yCoord = y; 
    }
    /** Default constructor; initializes to (0, 0). **/
    public Point2d() {
        // Call 2-argument constructor
        this(0, 0); 
    }
    public double getX() { return xCoord; } // Accessors
    public double getY() { return yCoord; }
    
    public void setX(double x) { xCoord = x; } // Mutators
    public void setY(double y) { yCoord = y; }
}