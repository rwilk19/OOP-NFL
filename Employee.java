package nfl;

import java.util.Collection;

//Generic Employee class, extended by Player and Coach subclasses
public abstract class Employee<AnyType>{
	String name;
	double salary;
	 
	public Employee(String name, double sal) {
		this.name = name;
		this.salary = sal;
		
	}
	//No argument constructor
	public Employee() {
		this.name = "John Smith";
		this.salary = 45000;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setSalary(double sal) {
		this.salary = sal;
	}
	public double getSalary() {
		return salary;
	}
	
	//The subclasses of Employee (such as Player and Coach) and Player's subclass (Quarterback) implement this parent class'
	//abstract method called calculate salary
	public abstract double calculateSalary();
	
	//Combines the salaries of objects in the list
	public static <AnyType> double combineSalary(Collection<? extends Employee<AnyType>>list) {
		
		double totalSalary = 0;
		//Performs the calculateSalary method on all Employee objects in the collection 
		for(Employee<AnyType> e : list) {	
			totalSalary += e.calculateSalary();
		}
		//Returns the totalSalary of the collection of players or coaches
		return totalSalary;
	}

}