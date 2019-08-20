import java.util.ArrayList;

// class for testing containers

public class TestContainers {
	/* main function - calls other container test functions */
	public static void main(String[] args) {
		System.out.println("testing different containers");
		testList();
	}
	/* test ArrayLists */
	public static void testList() {
		System.out.println("List");
		ArrayList<Integer> newList = new ArrayList<Integer>();
		newList.add(6);
		newList.add(9);

		for (int i = 0; i <newList.size(); i++) {
			System.out.println(newList.get(i));
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
}