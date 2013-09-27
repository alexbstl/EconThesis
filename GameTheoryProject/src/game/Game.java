package game;


public class Game extends Thread {
	public Bird a;
	public Bird b;
	private Thread thread;
	public int win;
	public int cost;
	public Game (Bird a, Bird b, int win,int cost){
		this.a=a;
		this.b=b;
		this.win=win;
		this.cost=cost;
	}
	public void rungame(){
		System.out.println("win is worth " + win + " cost is worth "+ cost);
		thread=new Thread(){
			public void run(){
				if(birdcheck()){
					removebirds();
					if(a.getPlay()&&b.getPlay()){
						playGame();
						System.out.println("Bird A is type "+a.getType()+" and has score: "+a.Score);
						System.out.println("Bird B is type "+b.getType()+" and has score: "+b.Score);
						a.setPlay(false);
						b.setPlay(false);
						System.out.println("Bird "+a.identifier + " played Bird " + b.identifier);
					}			
				}
			}
		};
		thread.start();
	}
	public Thread getThread() {
		return thread;
	}
	public void setThread(Thread thread) {
		this.thread = thread;
	}
	private boolean birdcheck(){
		if(a.canBeAltered&&b.canBeAltered){
			return true;
		} else
			try {
				sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		return false;
	}
	private void removebirds(){
		a.canBeAltered=false;
		b.canBeAltered=false;
	}
	private void freebirds(){
		a.canBeAltered=true;
		b.canBeAltered=true;
	}
	private void playGame(){
		if(a.getType()==1){
			//System.out.println("a is a hawk");
			if(b.getType()==0){
				a.Score+=win;
			}else if(b.getType()==1){
				a.Score+=(win/2);
				a.Score-=cost;
				b.Score+=(win/2);
				b.Score-=cost;
			}

		}else if(a.getType()==0){
			//System.out.println("a is a peaceloving hippie");
			if(b.getType()==0){
				a.Score+=(win/2);
				b.Score+=(win/2);
			}else if(b.getType()==1){
				b.Score+=win;
			}

		}
		freebirds();
	}

}