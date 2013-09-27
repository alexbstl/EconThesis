package game;

import java.util.ArrayList;
import java.util.Random;

public class Model {
	
	ArrayList<Bird> UnplayedBirds= new ArrayList<Bird>();
	ArrayList<Bird> Playedbirds= new ArrayList<Bird>();
	ArrayList<Thread> threads = new ArrayList<Thread>();

	public int numberofbirds;
	public int numberOfGames;
	public int victory;
	public int cost;
	public Random random;
	public Model(){
		random = new Random();
		this.numberofbirds=6;
		this.numberOfGames=numberofbirds/2;
		this.victory=4;
		this.cost=1;
		for(int i = 0; i<numberofbirds;++i){
			UnplayedBirds.add(new Bird(random.nextInt(2),i));
		}
	}
	public void gametime(){
		for(int i = 0;i<numberOfGames;++i){
			int a = random.nextInt(UnplayedBirds.size());
			Bird Birda=UnplayedBirds.get(a);
			UnplayedBirds.remove(Birda);
			Playedbirds.add(Birda);
			int b = random.nextInt(UnplayedBirds.size());
			Bird Birdb=UnplayedBirds.get(b);
			Playedbirds.add(Birdb);
			UnplayedBirds.remove(Birdb);
			Game game = new Game(Birda, Birdb,victory,cost);
			game.rungame();
			threads.add(game.getThread());
		}
		
		
	}
	public void run(){
		this.gametime();
//		for(Thread a: threads){
//			try {
//				a.join();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
		for(Bird a:Playedbirds){
			System.out.println("Bird number " + a.identifier+ " has score "+a.Score);
		}
	}
}

