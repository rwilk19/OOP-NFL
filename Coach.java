package nfl;

import java.util.Observable;
import java.util.Observer;
//The Coach class extends "is a" employee and implements the Observer interface
public class Coach extends Employee<Coach> implements Observer {
	public static final double BASE_SALARY = 500000.00;
	private String name;
	private int age;
	private int yearsExperience;
	int careerWins;
	int careerLosses;
	private double salary;
	
	//Constructor for Coach class
	public Coach(String name, int age, int xp, int win, int loss) {
		this.name = name;
		this.age = age;
		this.yearsExperience = xp;
		this.careerWins = win;
		this.careerLosses = loss;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public void setYearsExperience(int experience) {
		this.yearsExperience = experience;
	}
	public int getYearsExperience() {
		return yearsExperience;
	}
	public void setWins(int wins) {
		this.careerWins += wins;
	}
	public int getWins() {
		return careerWins;
	}
	public void setLosses(int losses) {
		this.careerLosses -= losses;
	}
	public int getLosses() {
		return careerLosses;
	}
	public void setSalary(double sal) {
		this.salary = sal;
	}
	public double getSalary() {
		return salary;
	}
	public String toString() {
		return "Coach Name : " + this.name + ", Age: " + this.age + ", Years Experience: " + this.yearsExperience +
				", Career Wins: " + this.careerWins + ", Career Losses: " + this.careerLosses;
	}
	
	@Override
	public double calculateSalary() {
		double winningPercent = this.careerWins / (this.careerLosses + this.careerWins);
		int experience = this.yearsExperience;
		double salaryAmount;
		salaryAmount = BASE_SALARY + 1000000 * winningPercent + 50000 * experience;
		return salaryAmount;
		
	}
	//Implements the update method required by the Observable
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
				this.careerWins + ", Losses: " + this.careerLosses);
	}

}
