/* basic class for creating economic data, storing the data in
 * a list of PollData objects, and returning a LinkedList of
 * PollData */

import java.util.*;

public class GenerateData {
	// 2-D array of all data
	private static int numPolls = 18;
	private static int pollAttributes = 3;
	private static double[][] pollArray= {
		                          {25, 2, 2.0},
        		                  {32, 4, 2.6},
        		                  {17, 3, 2.3},
        		                  {45, 5, 1.7},
        		                  {10, 5, 1.3},
        		                  {18, 7, 1.8},
        		                  {40, 8, 1.5},
        		                  {27, 11, 0.3},
        		                  {38, 12, 0.1},
        		                  {14, 14, -0.8},
        		                  {28, 14, -1.9},
        		                  {25, 15, -2.8},
        		                  {30, 17, -3.9},
        		                  {30, 16, -4.2},
        		                  {25, 19, -1.7},
        		                  {28, 20, -1.0},
        		                  {15, 22, 0.5},
        		                  {13, 23, 0.6}
        		                 };

	/** returns economic poll data as a LinkedList
	 *  
	 *  inputs - none
	 *  outputs - LinkedList of PollData elements
	 *  */
	public static LinkedList<PollData> outputData() {
		// declare LinkedList of poll data
		LinkedList<PollData> allPollData = new LinkedList<PollData>();

		// iterate through pollArray and convert to pollData type
		for (int i=0; i < numPolls; i++){
			// extract out fields from each element in pollArray
			int numRespond = (int) pollArray[i][0];
			int timePeriod = (int) pollArray[i][1];
			float growthForecast = (float) pollArray[i][2];

			// call constructor and create new PollData object
			PollData newPoll = new PollData(numRespond, timePeriod, growthForecast);
			// add to LinkedList with all the poll data
			allPollData.add(newPoll);
		}
		return allPollData;
	}
}
