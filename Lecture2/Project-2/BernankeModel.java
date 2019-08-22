/* BernankeModel class implementation of EconModel */

import java.util.*;      // import util class

public class BernankeModel implements EconModel {
	private LinkedList<Float> aggForecast;               // aggregated growth forecast
	private TreeMap<Integer, LinkedList<PollData>> groupedData;    // map of time scale to LinkedList of PollData
	
	/** add economic forecast data to class 
	 *  store data in a TreeMap*/
	public void getData() {
		// call method to receive data in a list
		LinkedList<PollData> pollData = GenerateData.outputData();

		// sort the list by date
		Collections.sort(pollData);

		// LinkedList w/ all PollData elements for a single quarter
        LinkedList<PollData> quarterList = new LinkedList<PollData>();
        // maximum time period for a PollData object to be added to
        // current list
        int month = 3;
        // instantiate TreeMap
        groupedData = new TreeMap<Integer, LinkedList<PollData>>();
		// iterate through the list, creating LinkedLists of PollData
		// with common time periods and added to TreeMap
		for (PollData p : pollData) {
			// check that pollData applies to current period
			while (p.getTimePeriod() > month) {
				System.out.println(quarterList);
				// pollData applies to later period 
				// add the old month, quarterList, to groupedData is key, value pair
				groupedData.put(month, quarterList);
				// create a new quarterList
		        LinkedList<PollData> newQuarterList = new LinkedList<PollData>();
		        // set quarterList to refer to newQuarterList
		        quarterList = newQuarterList;
		        // update the month - go through loop again and see if p belongs
		        // in timePeriod
		        month += 3;
			}
			// p is in the current time period - add to the quarterList
			quarterList.add(p);
		}
		System.out.println(groupedData);
		return;
	}

	/** create economic forecast based on interest rates */
	public void createForecast(float[] interestRates) {

	}

	/* create a graph plotting the projected growth rate */
	public void createGraph() {

	}
}