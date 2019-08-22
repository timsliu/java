import java.util.*;

// PollData class

/*
 * class holds information for economic growth
 * poll data
 */

public class PollData implements Comparable<PollData> {
    /** number of respondents to this poll */
	private int numRespond;
	/** forecast period (months from present) */
	private int timePeriod;
	/** average forecasted growth */
	private float growthForecast;

    /** Constructor to initalize all fields */
	public PollData(int numRespond, int timePeriod, float growthForecast) {
		this.numRespond = numRespond;
		this.timePeriod = timePeriod;
		this.growthForecast = growthForecast;

	}

	/** zero argument constructor */
	public PollData() {
		// call constructor - default all values to zero
		this(0, 0, 0);
	}


	/** accessor function for number of respondents */
	public int getNumRespond() {
		return this.numRespond;
	}
    /** accessor function for corresponding time period */
	public int getTimePeriod() {
		return this.timePeriod;
	}
    /** accessor function for growth forecast */
	public float getGrowthForecast () {
		return this.growthForecast;
	}

	/** set number of respondents */
	public void setRespondents(int val) {
		this.numRespond = val;
	}
	/** set time period */
	public void setTimePeriod(int val) {
		this.timePeriod = val;
	}
	/** set growth forecast */
	public void setForecast(float val) {
		this.growthForecast = val;
	}

	/** equal function to check for equality w/ other functions */
	public boolean equals(PollData other) {
		// check that all fields are equal
		if ((this.numRespond == other.numRespond) && 
			(this.timePeriod == other.timePeriod) && 
			(this.growthForecast == other.growthForecast)) {
			return true;
		}
		// not all fields are equal
		return false;
	}

	/** comparator function for ordering */
	public int compareTo(PollData other) {
		// sort based on time period - later time periods are larger
		// must cast result to integer
		return (int) java.lang.Math.signum(this.timePeriod - other.timePeriod);
	}

	/** hash function */
	public int hashcode() {
		int hash = 11;      // prime value

		//combine with field values
		hash = 19 * hash + this.numRespond;
		hash = 7 * hash + this.timePeriod;
		hash = 29 * hash + (int) this.growthForecast;

		return hash;
	}

}





