import java.util.*;

// class for testing containers

public class TestContainers {
	/* main function - calls other container test functions */
	public static void main(String[] args) {
		System.out.println("testing different containers");
		testList();
		// testMap();
	}
	/* test ArrayLists */
	public static void testList() {
		System.out.println("List");
		ArrayList<Integer> newList = new ArrayList<Integer>();
		newList.add(6);
		newList.add(9);
		newList.add(12);

		for (int i = 0; i <newList.size(); i++) {
			System.out.println(newList.get(i));
		}

		// test iterator
		Iterator<Integer> iter = newList.iterator();
		do {
			System.out.println(iter.next());
		} while(iter.hasNext());

		// test enhanced for - loop syntax
		for (Integer i: newList) {
			System.out.println("New element!: " + i);
		}
		return;
	}
	/* test arrays */
	public static void testArray() {
		System.out.println("Testing array");
		// declare an array of integers
		int[] myArray;
		// allocate memory
		myArray = new int[4];
		for (int i = 0; i < 4; i ++) {
			//myArray[i] = i;
			System.out.println(myArray[i]);
		}
		return;
	}
	// test maps
	public static void testMap() {
		System.out.println("Testing HashMaps");
		HashMap<String, String> stateCapitals = new HashMap<>();

		// add some elements to our new map
		stateCapitals.put("Indiana", "Indianapolis");
		stateCapitals.put("Delaware", "Dover");
		stateCapitals.put("Washington", "Olympia");

		// print out the map
		System.out.println(stateCapitals);

		// get size and print it

		int mapSize = stateCapitals.size(); // line not necessary
		System.out.println(mapSize);
		// check if element is in there
		if (stateCapitals.containsKey("Washington")) {
			System.out.println(stateCapitals.get("Washington"));
		}

		return;
	}
}






