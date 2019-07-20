package nfl;

import java.util.Observable;
import java.util.Observer;

public class Quarterback extends Player implements Observer {
	int wins; //Total career wins and losses
	int losses;
	double completionPercentage; //A measure of how accurate a Quarterback is throwing the football
	
	//Constructor for Quarterback class
	public Quarterback(String name, int age, int xp, int jerseySales, PlayerRating rating, double accuracy, int win, int loss) {
		super(name, age, xp, jerseySales, rating);
		this.completionPercentage = accuracy;
		this.wins = win;
		this.losses = loss;
	}
	
	//Since Player class implements RevenueSource interface and Quarterback is a sub-class of Player...
	//then Quarterback inherits this property. However, instead of inheriting the Player class implementation,
	//Quarterback salaries are based on a somewhat different set of criteria, and so this will override the 
	//Player class implementation 
	@Override
	public double calculateSalary() {
		double rating = this.rating.getPlayerRating();
		double experience = this.getYearsInLeague();
		double completionPercent = this.getCompletionPercentage();
		double bonus = 0;
		double winPercentage = this.wins / (this.wins + this.losses);
		if(completionPercent > 0.60) {
			bonus = 500000;
		}
		if(winPercentage > 0.65) {
			bonus += 2000000;
		}
		double salaryAmount;
		salaryAmount = BASE_SALARY + 25000 * rating + 50000 * experience + bonus;
		
		return salaryAmount;	
	}
	public void setWins(int wins) {
		this.wins += wins;
	}
	public int getWins() {
		return wins;
	}
	public void setLosses(int losses) {
		this.losses -= losses;
	}
	public int getLosses() {
		return losses;
	}
	public void setCompletionPercentage(double completion) {
		this.completionPercentage = completion;
	}
	public double getCompletionPercentage() {
		return completionPercentage;
	}
	public String toString() {
		return "Quarterback Name: " + this.name + ", Age: " + super.getAge() + ", Years In League: " + 
				super.getYearsInLeague() +  ", Rating: " + this.rating + ", Career Wins: " + 
				this.wins + ", Career Losses " + this.losses;
	}

	//Implements the update method required by the interface
	@Override
	public void update(Observable o, Object arg) {
		String value = arg.toString();
		int val = Integer.parseInt(value);
		if(val == 1) {
			this.setWins(val);
		}
		if(val != 1) {
			this.setLosses(val);
		}
		System.out.println("Name: " + this.getName() + " Their career record is: " + "Wins: " +
				this.wins + ", Losses: " + this.losses);	
	}
	
}
