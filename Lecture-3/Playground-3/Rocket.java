// parent class, defines a rocket

public abstract class Rocket {
	// number of rocket stages
	public int stages;
	protected boolean launched = false;

	// constructor
	public Rocket(int stages) {
		this.stages = stages;
	}

	// default constructor
	public Rocket() {
		this.stages = 1;
	}

	// fuel the rocket - abstract method
	public abstract void fuel();

    // launch the rocket
	public void launch() {
		System.out.println("Launching!!");
		this.launched = true;
		System.out.println(launched);
	}

    // destroy the rocket :(
	public void destroy() {
		System.out.println("Blow 'er up!");
	}

}
