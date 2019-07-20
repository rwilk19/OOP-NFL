package nfl;

import java.util.ArrayList;
import java.util.Observable;

//The GreenBayPackers class uses the Singleton Design pattern...
//which allows only one instance of the class to be created. 
public class GreenBayPackers extends NFLTeam {
	private static GreenBayPackers packers = null;
	private String name;
	private Coach headCoach;
	private ArrayList<Player> roster;
	private Stadium lambeauStadium;
	
	private GreenBayPackers() {
		//Passes in known values to super constructor
		super("GreenBay Packers", 320, 196, 7);
		headCoach = new Coach("Mike McCarthy", 55, 12, 125, 77);
		lambeauStadium = new Stadium("Lambeau Field", "1265 Lombardi Avenue", 81400, 89.50);
		roster = new ArrayList<Player>();
	}
	
	public static GreenBayPackers getGreenBayPackers() {
		if(packers == null) {
			packers = new GreenBayPackers();
		}
		return packers;
	}
	
	public Stadium getStadium() {
		return lambeauStadium;
	}
	
	public void setRoster(ArrayList<Player> list) {
		this.roster = list;
	}
	public ArrayList<Player> getRoster() {
		return roster;
	}
	public String toString() {
		return "Team Name: " + super.getName() + ", Head Coach: " + this.headCoach.getName() + ", Stadium: " + this.lambeauStadium.getName();
	}
	//Implements the update method required by the interface
	@Override
	public void update(Observable o, Object arg) {
		String value = arg.toString();
		int val = Integer.parseInt(value);
		if(val == 1) {
			super.setWins(val);
		}
		if(val != 1) {
			super.setLosses(val);
		}
		System.out.println("Name: " + super.getName() + " Their career record is: " + "Wins: " +
				super.getWins() + ", Losses: " + super.getLosses());
		
	}
}
