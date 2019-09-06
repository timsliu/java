// one of two child classes of Rocket super class

public class SolidRocket extends Rocket {

    // constructor
	public SolidRocket() {
		super(1);
	}

	// implement fueling method
	public void fuel() {
		System.out.println("Fueling rocket with solids...");
	}


	// override launch method
	@Override
	public void launch() {
		System.out.println("Lighing the candles!!");
		super.launch();
	}
}//
