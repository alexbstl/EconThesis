package game;

public class Bird {
	private int strategy;
	public boolean canBeAltered;
	public int Score;
	private boolean canplay;
	public final int identifier;

	public Bird(int type, int identifier) {
		super();
		this.identifier=identifier;
		this.strategy = type;
		this.canBeAltered=true;
		Score=0;
		this.setPlay(true);
	}
	public int getType() {
		return strategy;
	}

	public void setStrategy(int type) {
		this.strategy = type;
	}
	public void setPlay(boolean play){
		canplay=play;
	}
	public boolean getPlay(){
		return canplay;

	}
}
