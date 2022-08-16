package projectDatabase;

public class DistributedDB extends DB{

	// DistributedDB - Fields
	//instance variables (protected):
	protected int numberOfUsers;
	protected double costPerUser;
	
	
	//constant (public static final)
	public static final double COST_FACTOR = 1.1;
	
	// DistributedDB Constructor
	public DistributedDB(String name, double base_cost, double db_Storage) {
		super(name, base_cost, db_Storage);
		// TODO Auto-generated constructor stub
	}

	public DistributedDB(String name, double base_cost, double db_Storage, int noOfUsers, double costPerUser) {
		super(name, base_cost, db_Storage);
		this.numberOfUsers = noOfUsers;
		this.costPerUser = costPerUser;
	}
	
	

	// DistibutedDB - Methods

	public int getNumberOfUsers() {
		return numberOfUsers;
	}

	public void setNumberOfUsers(int numberOfUsers) {
		this.numberOfUsers = numberOfUsers;
	}

	public double getCostPerUser() {
		return costPerUser;
	}

	public void setCostPerUser(double costPerUser) {
		this.costPerUser = costPerUser;
	}
	
	public double userCost() {
		double userCost_value = numberOfUsers * costPerUser;
		return userCost_value;
	}

	


	public double getCostFactor() {
		
		/*
		 * Although this method is returning a constant, it should not be static to
		 * ensure the cost factor for this class is returned of when called on an object
		 * of this class
		 */
		
		return COST_FACTOR;
	}
	
	
	@Override
	public double monthlyCost() {
		
		return base_cost + userCost() * DistributedDB.COST_FACTOR;
	}
	
	
	@Override
	public String toString() {
		return super.toString() + "Number of Users: " + numberOfUsers + "\n"+
				"Cost per User: " + String.format("$%,.2f", costPerUser) +  "\n"+
				"User Cost: "  + String.format("$%,.2f",userCost()) +  "\n"+
				"Cost Factor: " + getCostFactor();
	}

	
}
