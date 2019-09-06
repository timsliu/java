// main class for testing class inheritance

public class BuildRockets {
	public static void main (String[] args){
		Rocket bigBoom = new LiquidRocket(1);
		bigBoom.fuel();
		bigBoom.launch();

		bigBoom = new SolidRocket();
		bigBoom.fuel();
		bigBoom.launch();
	}
}
