/* BernankeModel class implementation of EconModel */

import java.util.*;      // import util class

public class BernankeModel implements EconModel {
	private LinkedList<Float> aggForecast;               // aggregated growth forecast
	private TreeMap<Integer, LinkedList<PollData>> groupedData;    // map of time scale to LinkedList of PollData
	
	/** add economic forecast data to class 
	 *  store data in a TreeMap*/
	public void getData() {
		// call method to receive data in a list
		List<PollData> pollData = GenerateData.outputData();

		// sort the list by date

		// iterate through the list, creating LinkedLists of PollData
		// with common time periods and added to TreeMap

	}

	/** create economic forecast based on interest rates */
	public void createForecast(float[] interestRates) {

	}

	/* create a graph plotting the projected growth rate */
	public void createGraph() {

	}
}