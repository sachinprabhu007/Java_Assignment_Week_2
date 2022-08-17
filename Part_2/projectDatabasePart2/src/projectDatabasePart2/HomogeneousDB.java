package projectDatabasePart2;

public class HomogeneousDB extends DistributedDB{

	// HomogenousDB - Field
	public static final double COST_FACTOR=1.2;

	
	// HomogenousDB - Constructor
	
	public HomogeneousDB(String name, double base_cost, double db_Storage,int noOfUsers, double costPerUser) {
		super(name, base_cost, db_Storage,noOfUsers,costPerUser);
	}

	
	// HomogenousDB - Methods
	
	public double getCostFactor() {
		
		/*
		 * Although this method is returning a constant, it should not be static to
		 * ensure the cost factor for this class is returned of when called on an object
		 * of this class.
		 */
		
		return COST_FACTOR;
	}	
	
	@Override
	public double monthlyCost() {
		return base_cost + userCost() * HomogeneousDB.COST_FACTOR;
	}
		
	/*
	 * @Override public void printCostFactor() { System.out.println("Cost Factor: "
	 * + HomogenousDB.COST_FACTOR); }
	 */
}
