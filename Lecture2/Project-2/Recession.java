/* Description: entry point for generating economic forecasts 
 * 
 * Revision History
 * 08/21/19    Tim Liu    started file
 * 08/29/19    Tim Liu    main function calls BernankeModel to generate forecasts
 * 08/29/19    Tim Liu    main function calls models in a loop
 */

import xchart.*;

public class Recession {
	// projected interestRates for future quarters
	private static float[] interestRates = { 4.00f, 3.50f, 4.00f, 3.00f,
	                                         2.50f, 2.00f, 1.00f, 0.50f };

	/* Description: main function; creates instances of implementations of 
	 *              EconModel and generates growth forecasts. Generates
	 *              graphs illustrating growth
	 * Inputs:      None
	 * Outputs:     None
	 */
	public static void main(String[] args) {
		System.out.println("Generating economic forecasts...");

		// create economic models
        EconModel modelY = new YellenModel();
        EconModel modelB = new BernankeModel();

        EconModel[] growthModels = {modelY, modelB};

        for (EconModel model:growthModels) {
    		System.out.println("Running " + model.getName() + " recession model...");
            model.getData();
            model.createForecast(interestRates);
            System.out.println(model.getForecast());
        }
	}
}