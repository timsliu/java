/* Name: YellenModel
 *
 * Description: implementation of EconModel with simpler forecasting
 *              algorithm and data packaging than BernankeModel
 *
 * Table of contents
 *
 * Revision History
 * 08/29/19    Tim Liu    added getForecast and getName method signatures
 * 08/30/19    Tim Liu    wrote CreateForecast method
 */

import java.util.*;

public class YellenModel implements EconModel {
	private LinkedList<Float> aggForecast;             // aggregated growth forecast
	private LinkedList<Float> pollForecast;            // estimated growth based on only poll data
	private String modelName = "Yellen";

	/** Description: add economic forecast data to object and  
	 *               store the first poll of each quarter to pollForecast
	 *  Inputs:      None
	 *  Outputs:     None
	 *  Attributes:  pollForecast populated w/ growth rate of first poll
	 *               of each quarter
	 */
	
	public void getData() {
		// call method to receive data in a list
		LinkedList<PollData> pollData = GenerateData.outputData();
		// sort pollData by date
		Collections.sort(pollData);
		// initialize pollForecast
		pollForecast = new LinkedList<Float>();

        int quarterStartMonth = 0;

		// loop through pollData and only use first survey for each quarter
		for (PollData p:pollData) {

			// only add the first poll for the quarter
			if (p.getTimePeriod() >= quarterStartMonth) {
				pollForecast.add(p.getGrowthForecast());
				quarterStartMonth += 3;
			}
		}
	}

    /** Description: generate economic growth forecast based on 
     *               pollForecast and projected interest rates
     *
     * Inputs:       interestRates - float array of projected interest rates
     *               for each quarter
     * Outptus:      None
     * Attributes:   aggForecast - aggregated growth forecast for each quarter
     */
	public void createForecast(float[] interestRates) {
		if (pollForecast == null) {
			//groupedData is null - getData() hasn't been called
			System.out.println("getData() method not called");
			return;
		}

		if (interestRates.length != pollForecast.size()) {
			// groupedData and interestRates not the same length
			System.out.println("Mismatched interestRates and groupedData lengths");
			System.out.println("interestRates length: " + interestRates.length);
			System.out.println("groupdData length: " + pollForecast.size());
			return;
		}
		// initialize aggForecast
		aggForecast = new LinkedList<Float>();

        // iterator for going through poll forecast
        Iterator<Float> pollIter = pollForecast.iterator();
        // index into interestRates
        int i = 0;
        // loop through interestRates and pollForecasts, combinging
        // data into an aggregated forecast and adding to aggForecast
        while (pollIter.hasNext()) {
        	// create growth forecast
        	aggForecast.add(pollIter.next() - interestRates[i] + 2.0f);
        }
		return;
	}

	/** Description: accessor that returns aggForecast
	 *
	 *  Output: aggForecast
	 */
	public LinkedList<Float> getForecast() {
		if (aggForecast == null) {
			System.out.println("createForecast not called");
			return null;
		}
		return aggForecast;
	}

	/* Description: returns name of economic model 
	 * 
	 * Outputs: modelName - returns string w/ model name
	 */
	public String getName() {
		return modelName;
	}
}