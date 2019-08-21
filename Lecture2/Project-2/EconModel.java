/* EconModel interface for generating economic forecasts */

public interface EconModel {
	
	/** add economic forecast data to class */
	void getData();

	/** create economic forecast based on interest rates */
	void createForecast(float[] interestRates);

	/* create a graph plotting the projected growth rate */
	void createGraph();
}