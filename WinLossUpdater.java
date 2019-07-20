package nfl;

import java.util.Observable;

//This class is observed by GreenBayPackers, Quarterback, and Coach
public class WinLossUpdater extends Observable {
	final protected int loss = -1;
	final protected int win = 1;
	
	public void win() {
		System.out.println("Game won");
		setChanged();
		notifyObservers(win);
	}
	
	public void loss() {
		System.out.println("Game lost");
		setChanged();
		notifyObservers(loss);
	}

}
