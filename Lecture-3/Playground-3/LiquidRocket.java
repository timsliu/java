// one of two child classes of Rocket super class

public class LiquidRocket extends Rocket {

    // constructor
	public LiquidRocket(int stages) {
		super(stages);
	}

	// implement fueling method
	public void fuel() {
		System.out.println("Fueling rocket with liquids...");
	}

	// new method not in parent class
	public void ventFuel() {
		System.out.println("Venting fuel...");
	}

	// override launch method
	@Override
	public void launch() {
		System.out.println("Throttling up!");
		super.launch();
	}
}
