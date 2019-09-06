import java.util.*;       // import util class


// Example interface - everything is public
public class TestLists {
	// no method access modifiers
	public static void main(String[] args) {
		// create one list
		LinkedList<Integer> listA = new LinkedList<Integer>();
		LinkedList<Integer> listB = new LinkedList<Integer>();
		TreeMap<Integer, LinkedList<Integer>> mapA = new TreeMap<Integer, LinkedList<Integer>>();


        // fill it with some elements
		listA.add(1);
		listA.add(2);
		listA.add(3);
		// create a new list
		listB.add(5);
		listB.add(6);

		// stash the list in the tree map
		mapA.put(1, listA);
		
		// modify listA
		listA = listB;
		listA.add(7);

		System.out.println(listA);
		System.out.println(mapA.get(1));
		System.out.println(listB);

		LinkedList<Integer> listC = new LinkedList<Integer>();
		listA = listC;
		System.out.println(listC);
		System.out.println(listA);
		System.out.println(mapA.get(1));


	}
}