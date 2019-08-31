/* Name: BernankeModel
 *
 * Description: implementation of EconModel that takes in data
 *              and generates a fake model of economic growth
 *
 * Table of contents
 *
 * Revision History
 * 08/29/19    Tim Liu    added getForecast and getName methods
 * 08/29/19    Tim Liu    finished writing createForecast
 * 08/31/19    Tim Liu    changed getForecast to return as double array
 */
import java.util.*;      // import util class

public class BernankeModel implements EconModel {
	private LinkedList<Float> aggForecast;                        // aggregated growth forecast
	private TreeMap<Integer, LinkedList<PollData>> groupedData;   // map of time scale to LinkedList of PollData
	private String modelName = "Bernanke";
	
	/** Description: add economic forecast data to object and  
	 *               store data in the TreeMap groupData for later
	 *               analysis. Method does NOT analyze the data
	 *  Inputs:      None
	 *  Outputs:     None
	 *  Attributes:  groupedData populated
	 */
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
				// pollData applies to later period 
				// add the old month, quarterList, to groupedData as key, value pair
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
		// add last quarterList created to groupedData
		groupedData.put(month, quarterList);
		return;
	}

	/** Description: create economic forecast based on interest rates
	 *               and groupedData
	 *
	 *  Inputs:      interestRates - array float with projected interest rates for
	 *               future quarters
	 *  Outputs:     None
	 *
	 *  Attributes:  aggForecast - aggregated growth forecast populated
	 */
	public void createForecast(float[] interestRates) {

		if (groupedData == null) {
			//groupedData is null - getData() hasn't been called
			System.out.println("getData() method not called");
			return;
		}

		if (interestRates.length != groupedData.size()) {
			// groupedData and interestRates not the same length
			System.out.println("Mismatched interestRates and groupedData lengths");
			System.out.println("interestRates length: " + interestRates.length);
			System.out.println("groupdData length: " + groupedData.size());
			return;
		}
		// initialize aggForecast
		aggForecast = new LinkedList<Float>();

		// loop through groupdData and add new node to aggForecast on each loop
		for (int i = 0; i < groupedData.size(); i++) {
			// retrieve LinkedList of PollData for quarter
			LinkedList<PollData> quarterData = groupedData.get(3*(i+1));
			
			float weightedGrowth = 0;    // weighted average of growth across poll data
			int totalResp = 0;           // total number of respondents for surveys in quarter
			
			// loop through each PollData element and calculate weighted average
			for (PollData p : quarterData) {
				weightedGrowth += p.getGrowthForecast() * p.getNumRespond();
				totalResp += p.getNumRespond();
			weightedGrowth /= totalResp;
			}

			// create the aggregated growth forecast for quarter and incorporate interest rate
			aggForecast.add(weightedGrowth - 0.5f*interestRates[i] + 1);
		}
		return;

	}

	/** Description: accessor that returns aggForecast as double array
	 *
	 *  Output: aggForecast
	 */
	public double[] getForecast() {
		if (aggForecast == null) {
			System.out.println("createForecast not called");
			return null;
		}
		// convert list to Float array
		Float[] floatArray = aggForecast.toArray(new Float[aggForecast.size()]);
		// convert Float array to double array
		double[] doubleArray = new double[floatArray.length];
		// fill the array and cast Float to double
		for (int i = 0; i < doubleArray.length; i++) {
			doubleArray[i] = (double) floatArray[i];
		}
		return doubleArray;
	}

	/* Description: returns name of economic model 
	 * 
	 * Outputs: modelName - returns string w/ model name
	 */
	public String getName() {
		return modelName;
	}
}