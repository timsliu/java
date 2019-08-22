/* Description: entry point for generating economic forecasts 
 * 
 * Revision History
 * 08/21/19    Tim Liu    started file
 *
 */


public class Recession {
	public static void main(String[] args) {
		System.out.println("Generating economic forecasts...");
		// call Bernanke model
        EconModel modelB = new BernankeModel();
        modelB.getData();
	}
}