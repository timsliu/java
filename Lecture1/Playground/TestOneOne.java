public class TestOneOne {
	/*
	 * This method prints hello world
	 */
	public static void main(String[] args) {
        // declare a float
		float myFloat = 1.7778f;
		// declare a boolean
		boolean err = false;
		// test out a string
		String s1 = "Java!";
		String s2 = s1;
		s2 += 1;
        // Print the magic words
		System.out.println("Hello world!");
		System.out.println(myFloat);
		System.out.println(err);
		System.out.println(s1);
		System.out.println(s2);

        // initialize a variable
		int i = 1;
		// test simple do while loop
		do {
			i++;
			System.out.println(i);
		} while (i < 5);

	}
}