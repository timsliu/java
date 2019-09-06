/* Description: entry point for generating economic forecasts 
 * 
 * Revision History
 * 08/21/19    Tim Liu    started file
 * 08/29/19    Tim Liu    main function calls BernankeModel to generate forecasts
 * 08/29/19    Tim Liu    main function calls models in a loop
 * 08/30/19    Tim Liu    added plotting
 */

import org.knowm.xchart.*;
import java.io.*;

public class Recession {
	// projected interestRates for future quarters
	private static float[] interestRates = { 4.00f, 3.50f, 4.00f, 3.00f,
	                                         2.50f, 2.00f, 1.00f, 0.50f };
	// time axis
	private static double[] months = {3.0, 6.0, 9.0, 12.0, 15.0, 18.0, 21.0, 24.0};

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

        // loop running each economic model
        for (EconModel model:growthModels) {
    		System.out.println("Running " + model.getName() + " recession model...");
            model.getData();
            model.createForecast(interestRates);
        }
        
        // Create Chart
        XYChart growthChart = new XYChart(500, 400);
        growthChart.setTitle("Projected GDP growth");
        growthChart.setXAxisTitle("Months");
        growthChart.setYAxisTitle("Projected growth (%)");
        
        // Add series
        growthChart.addSeries("Bernanke Model", months, modelB.getForecast());
        growthChart.addSeries("Yellen Model", months, modelY.getForecast());
        
        // Save chart
        try {
            BitmapEncoder.saveBitmap(growthChart, "./GDP_growth", BitmapEncoder.BitmapFormat.PNG);
        }
        catch (IOException e){
        	System.out.println("Could not save chart");
        }
        // Show chart
        new SwingWrapper<XYChart>(growthChart).displayChart();

        return;
	}
}