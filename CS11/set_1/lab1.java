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

	/* main function */

	public static int final NUM_POINTS = 3

	public static void main(String[] args) {
		// declare an array of Point3d
		Point3d[] pArray;
		// allocate memory for NUM_POINTS 3D points
		pArray = new Point3d[NUM_POINTS];

		for(int i = 0; i < 3; i++) {
			pArray[i].setX(getDouble());
			pArray[i].setY(getDouble());
			pArray[i].setZ(getDouble());
		}


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