package projectDatabasePart2;

public class HeterogeneousDB extends DistributedDB {

	// HetorgenousDB - Field
	public static final double COST_FACTOR=1.3;

	// HetogrenousDB - Constructor
	
	public HeterogeneousDB(String name, double base_cost, double db_Storage,int noOfUsers, double costPerUser) {
		super(name, base_cost, db_Storage,noOfUsers,costPerUser);
	}

	// HeterogenousDB - Methods
	
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
			return base_cost + userCost() * HeterogeneousDB.COST_FACTOR;
		}
			
}
