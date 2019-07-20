package nfl;

//Player class is one of Employee class' subclasses
public class Player extends Employee<Player> implements RevenueSource<Player> {
	public static final double BASE_SALARY = 250000.00;
	
	private int age;
	private int yearsInLeague;
	private int jerseySales;
	PlayerRating rating;
	
	//Enum which represents how talented a player is
	public enum PlayerRating {
		Poor(10),
		BelowAverage(25),
		Average(50),
		Good(70),
		Great(90),
		ProBowl(98);
		
		private final double rating;
		
		PlayerRating(double rating) {
			this.rating = rating;
		}
		
		public double getPlayerRating() {
			return rating;
		}
	}
	
	public Player(String name, int age, int experience, int jerseySales, PlayerRating rating) {
		super(name, 0.0);
		this.age = age;
		this.yearsInLeague = experience;
		this.jerseySales = jerseySales;
		this.rating = rating;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public void setYearsInLeague(int experience) {
		this.yearsInLeague = experience;
	}
	public int getYearsInLeague() {
		return yearsInLeague;
	}
	public void setJerseySales(int jerseySales) {
		this.jerseySales = jerseySales;
	}
	public int getJerseySales() {
		return jerseySales;
	}
	
	public String toString() {
		return "Player Name: " + this.name + ", Age: " + this.age + ", Years In League: " + this.yearsInLeague + 
				", Jersey Sales: " + this.jerseySales + ", Rating: " + this.rating;
	}
	//Implements the calculateSalary method defined in Employee class
	@Override
	public double calculateSalary() {
		double rating = this.rating.getPlayerRating();
		int experience = this.yearsInLeague;
		double salaryAmount;
		salaryAmount = BASE_SALARY + 25000 * rating + 50000 * experience;
		return salaryAmount;
		
	}
	//Implements the abstract method in the RevenueSource interface
	@Override
	public double getRevenueAmt() {
		return this.getJerseySales() * 60;
	}

}
