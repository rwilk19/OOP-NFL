package nfl;

import java.util.Observer;

//The abstract NFLTeam class cannot be instantiated
public abstract class NFLTeam implements Observer {
	private String name;
	private Coach headcoach;
	private String city;
	private int wins;
	private int losses;
	private int numChampionshipsWon;
	
	//Constructor
	public NFLTeam(String name, Coach coach, String city, int win, int loss, int champ) {
		this.name = name;
		this.headcoach = coach;
		this.city = city;
		this.wins = win;
		this.losses = loss;
		this.numChampionshipsWon = champ;
	}
	//A second constructor
	public NFLTeam(String name, int wins, int losses, int champ) {
		this.name = name;
		this.wins = wins;
		this.losses = losses;
		this.numChampionshipsWon = champ;
	}
	//No argument constructor
	public NFLTeam() {
		this.name = "NFL Team";
		this.headcoach = null;
		this.city = "Large City";
		this.wins = 0;
		this.losses = 0;
		this.numChampionshipsWon = 0;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setCoach(Coach coach) {
		this.headcoach = coach;
	}
	public Coach getCoach() {
		return headcoach;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCity() {
		return city;
	}
	public void setWins(int wins) {
		this.wins += wins;
	}
	public void setLosses(int losses) {
		this.losses -= losses;
	}
	public int getWins() {
		return wins;
	}
	public int getLosses() {
		return losses;
	}
	public void setChampionships(int championships) {
		this.numChampionshipsWon = championships;
	}
	public int getNumChampionships() {
		return numChampionshipsWon;	
	}
	public String toString() {
		return "Team Name: " + this.name + ", Head Coach: " + this.headcoach.getName() + ", City: " + this.city;
	}
	
}
