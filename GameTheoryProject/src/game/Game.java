package game;

import java.util.Set;

public class Game {
	public Set<Bird> Birds;
	public Set<Bird> Hawk;
	public Set<Bird> Dove;
	public double HawkScore;
	public double DoveScore;
	public double cost;
	public double win;
	public static void main(String args[]){

	}

	public void game(Bird A, Bird B){
		int TypeA=A.getType();
		int TypeB=B.getType();
		if(TypeA==1&&TypeB==1){
			HawkScore+=win-2*cost;
		}
		if(TypeA+TypeB==1){
			HawkScore+=win;
		}
		if(TypeA+TypeB==0){
			DoveScore+=win;
		}
	}
	public void evolve(double HawkScore, double DoveScore){

	}

}
