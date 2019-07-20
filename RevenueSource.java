package nfl;

//Lets the unrelated Stadium and Player classes use the same blueprint...
//Although the implementations are different. 

public interface RevenueSource<AnyType> {
	
	public double getRevenueAmt();

}
