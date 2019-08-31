/* EconModel interface for generating economic forecasts */

import java.util.*;      // import util class


public interface EconModel {
	
	/** add economic forecast data to class */
	void getData();

	/** create economic forecast based on interest rates */
	void createForecast(float[] interestRates);

	/* return forecasted economic growth as a list */
	LinkedList<Float> getForecast();

	/* print name of model */
	String getName();
}