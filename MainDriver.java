package nfl;

import java.util.ArrayList;
import nfl.Player.PlayerRating;

//All testing is done in this MainDriver class
public class MainDriver {

	public static void main(String[] args) {
		
		//Creates an instance of GreenBayPackers class representing the Green Bay Packers NFL team
		//GreenBayPackers class uses Singleton Design Pattern 
		GreenBayPackers packers = GreenBayPackers.getGreenBayPackers();
		System.out.println(packers);
		System.out.println();
		
		GreenBayPackers packers2 = GreenBayPackers.getGreenBayPackers();
		//As you can see below, both packers1 and packers2 point to the same object
		//This is because with Singleton design pattern, only one instance of the class can be created.
		System.out.println("Demonstrating the Singleton Design Pattern: Both GreenBayPackers references "
				+ "point to the same object, \nshowing only one instance can be created.");
		//If true, both point to the same object, meaning there is only one instance of the class
		System.out.println("References point to the same object: " + (packers == packers2));
		System.out.println();
		
		Coach packersHeadCoach = packers.getCoach();
		System.out.println("Composition: GreenBayPackers 'has-a' Coach and Stadium (objects): \n"
		+ packersHeadCoach + "\n" + packers.getStadium());
		
		//Creates instances of the player class, which is a sub class of Employee
		Player runningBack = new Player("Aaron Jones", 24, 2, 10000, PlayerRating.Average);
		Player wideReceiver = new Player("Randall Cobb", 28, 8, 45000, PlayerRating.ProBowl);
		Player leftTackle = new Player("David Bakhtiari", 27, 5, 5000, PlayerRating.Great);
		Player kicker = new Player("Mason Crosby", 34, 11, 50000, PlayerRating.Great);
		Player lineBacker = new Player("Jake Ryan", 26, 2, 500, PlayerRating.BelowAverage);
		
		System.out.println();
		//Creates instance of the Quarterback class and stores in Player reference
		//This demonstrates use of Polymorphism by storing a Quarterback object in a reference to its parent class Player
		System.out.println("Demonstrating polymorphism: A Quarterback object is stored in a Player class reference, \n"
				+ "and the toString method of Quarterback class is called: ");
		Player qb = new Quarterback("Aaron Rodgers", 35, 13, 75000, PlayerRating.ProBowl, 0.648, 98, 55);
		System.out.println(qb.toString());
		System.out.println();
		
		System.out.println("Calls the same method \"abstract calculateSalary()\" in Employee class, but different implementations \n" +
		"for Player and Quarterback and Coach. Uses different implementation in all three cases.");
		//Calls the calculate salary method
		double runningBackSalary = runningBack.calculateSalary();
		runningBack.setSalary(runningBackSalary);
		System.out.println("Runningback Name: " + runningBack.getName() + ", Salary: " + runningBack.getSalary());
		
		//Calls the calculate salary method
		double qbSalary = qb.calculateSalary();
		qb.setSalary(qbSalary);
		System.out.println("QB Name: " + qb.getName() + ", Salary: " + qb.getSalary());
		//Calls the calculate salary method
		double headCoachSalary = packers.getCoach().calculateSalary();
		packersHeadCoach.setSalary(headCoachSalary);
		System.out.println("Coach Name: " + packersHeadCoach.getName() + ", Salary: " + packersHeadCoach.getSalary());
		System.out.println();
		
		//Creates an array list representing part of team's roster
		ArrayList<Player> salaryCap = new ArrayList<Player>();
		packers.setRoster(salaryCap);
		salaryCap.add(runningBack);
		salaryCap.add(wideReceiver);
		salaryCap.add(leftTackle);
		salaryCap.add(kicker);
		salaryCap.add(lineBacker);
		//Since Quarterback extends Player, it can be added to the array list of type Player
		salaryCap.add(qb);
		
		//The generic Employee class combineSalary method, with Player objects here
		System.out.println("Demonstrates the use of combineSalary method in 'Generic' Employee class, which computes\n" +
		"and accumulates the salaries of for all elements in the Collection of Employee type objects, which\n"
		+ "in this case are Player objects:");
		double packersPlayerSalary = Employee.combineSalary(salaryCap);
		System.out.println("Combined Salary of players on roster: " + packersPlayerSalary);
		System.out.println(); 
		
		//Create instances of the Coach class
		Coach offensiveCoordinator = new Coach("Joe Phillbin", 57, 7, 24, 28);
		Coach defensiveCoordinator = new Coach("Mike Pettin", 51, 9, 31, 24);
		Coach specicalTeamsCoach = new Coach("Ron Zook", 62, 25, 24, 28);
		Coach lineBackersCoach = new Coach("Patrick Graham", 42, 7, 15, 17);
		Coach defensiveLineCoach = new Coach("Jerry Montgomery", 36, 4, 11, 12);
		
		//Adds the coaches to an arrayList of type Coach
		ArrayList<Coach> coachSalaries = new ArrayList<Coach>();
		coachSalaries.add(packersHeadCoach);
		coachSalaries.add(offensiveCoordinator);
		coachSalaries.add(defensiveCoordinator);
		coachSalaries.add(specicalTeamsCoach);
		coachSalaries.add(lineBackersCoach);
		coachSalaries.add(defensiveLineCoach);
		
		//The generic Employee class combineSalary method this time with Coaches
		System.out.println("Demonstrates the use of combineSalary method from 'Generic' Employee class, which computes\n" +
				"and accumulates the salaries of for all elements in the Collection of Employee type objects, which\n"
				+ "in this case are Coach objects:");
		double packersCoachSalary = Employee.combineSalary(coachSalaries);
		System.out.println("Combined Salary of GreenBay Packers coaches: " + packersCoachSalary);
		
		Stadium stadium = packers.getStadium();
		System.out.println();
		//RevenueSource interface has abstract method getRevenueAmount()
		//Both Stadium and Player classes are RevenueSources and implement the interface in their unique way
		System.out.println("Demonstrating the RevenueSource interface: two unrelated classes, Player and Stadium, are "
				+ "\nimplementing the same blue print to get their revenue amounts, but in different ways: ");
		double stadiumRevenue = stadium.getRevenueAmt();
		System.out.println(stadium.getName() + " Revenue: " + stadiumRevenue);
		double playerRevenue = qb.getRevenueAmt();
		System.out.println(qb.getName() + " Revenue: " + playerRevenue);
		System.out.println();
		
		//Pass in QB, Coach, and GreenBayPackers objects into WinLossUpdater method
		System.out.println("Demonstrating the Observer Design Pattern: The WinLossUpdater class is the \n" +
		"Observable and the three observers are GreenBayPackers, HeadCoach, and Quarterback classes.\n" +
		"When a game is won or lost, the WinLossUpdater updates it's three observers. Those observers then\n" +
		"take the result and update the value of their corresponding fields.");
		
		WinLossUpdater game = new WinLossUpdater();
		game.addObserver(packers);
		//Had to cast qb because variable 'qb' is stored in a Player reference and Player class doesn't...
		//extend Observer, only Quarterback, Coach, and GreenBayPackers do
		game.addObserver((Quarterback)qb);
		game.addObserver(packersHeadCoach);
		System.out.println();
		//The observable calls its win method and updates the three observers
		game.win();
		System.out.println();
		game.win();
		System.out.println();
		game.win();
		System.out.println();
		game.loss();
	}
}
