/** 
 * Lab1.java
 *
 * Main class for Lab1 - creates instances of the Point3d class
 *
 * Revision History
 * 02/23/19    Tim Liu    created file
 */

import java.io.*;

/**
 * Name:         Lab1
 * Description:  Ask for user input and ceates 3 instances of the Point3d
 *               class. Computes the area of a triangle formed by the three
 *               points.
 *               
 */

public class Lab1 {
    /* constant number of points */
	final static int NUM_POINTS = 3;

    /* main function */
	public static void main(String[] args) {
		// declare an array of Point3d
		Point3d[] pArray;
		// allocate memory for NUM_POINTS 3D points
		pArray = new Point3d[NUM_POINTS];

		for(int i = 0; i < 3; i++) {
            // loop getting coordinates for three points
            System.out.print("Enter x" + (i+1) + ": ");
			double x = (getDouble());
            System.out.print("Enter y" + (i+1) + ": ");
			double y = (getDouble());
            System.out.print("Enter z" + (i+1) + ": ");
			double z = (getDouble());
            pArray[i] = new Point3d(x, y , z);
		}

        // call method to compute area
        double area = computeArea(pArray[0], pArray[1], pArray[2]);

        // -1 signifies an error occurred
        if (area == -1.0) {
            System.out.println("Error - points are not unique");
        }
        // otherwise print out the area
        else {
            System.out.println("Area of triangle: " + area);

        }
        return;
	}

    /** 
     * computes the area of a triangle based on three Point3d
     * objects
     */

    public static double computeArea(Point3d p1, Point3d p2, Point3d p3){

        // check if any of the points are equal
        if (p1.equals(p2) || p2.equals(p3) || p3.equals(p1)) {
            // if points are equal then return -1 to signify error
            return -1.0;
        }

 
        // get the distance between each of the points
        double d1 = p1.distanceTo(p2);
        double d2 = p2.distanceTo(p3);
        double d3 = p3.distanceTo(p1);

        //  Heron's formula for calculating area
        double semi = (d1 + d2 + d3)/2;
        double area = Math.sqrt(semi * (semi - d1) * (semi - d2) * (semi - d3));

        return area;

    }

    /**
     * Obtains one double-precision floating point number from
     * standard input.
     *
     * @return return the inputted double, or 0 on error.
     */
    public static double getDouble() {

        // There's potential for the input operation to "fail"; hard with a
        // keyboard, though!
        try {
            // Set up a reader tied to standard input.
            BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

            // Read in a whole line of text.
            String s = br.readLine();

            // Conversion is more likely to fail, of course, if there's a typo.
            try {
                double d = Double.parseDouble(s);

                //Return the inputted double.
                return d;
            }
            catch (NumberFormatException e) {
                // Bail with a 0.  (Simple solution for now.)
                return 0.0;
            }
        }
        catch (IOException e) {
            // This should never happen with the keyboard, but we'll
            // conform to the other exception case and return 0 here,
            // too.
            return 0.0;
        }
    }

}