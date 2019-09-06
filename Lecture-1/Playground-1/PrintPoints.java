public class PrintPoints {
	/*
	 * This method prints hello world
	 */
	public static void main(String[] args) {
		Point2d p = new Point2d(3.1, 2.4);
        printPoint(p);
	}

	static void printPoint(Point2d p) {
		System.out.println(p.getX() + ", " + p.getY());
		return;
	}
}