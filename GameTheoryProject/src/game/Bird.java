package game;

public class Bird {
	private int strategy;

	public Bird(int type) {
		super();
		this.strategy = type;
	}
	public int getType() {
		return strategy;
	}

	public void setStrategy(int type) {
		this.strategy = type;
	}
}
