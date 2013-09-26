package game;

public class Bird {
	private int strategy;

	public Bird(int type) {
		super();
		this.strategy = type;
	}
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
