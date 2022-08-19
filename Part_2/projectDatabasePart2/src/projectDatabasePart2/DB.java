package projectDatabasePart2;

public abstract class DB implements Comparable<Object> {
	
	
	// DB - Fields
	protected String name; // Name
	protected double base_cost; // Base Cost
	protected double Db_Storage; // Database Storage in Terabytes (TB)
	protected static int count = 0; // Count of DB objects
	
	
	// DB - Constructor
	public DB(String name, double base_cost, double db_Storage) {
		super();
		this.name = name;
//		this.base_cost = base_cost;
		Db_Storage = db_Storage;
		count = count + 1;
	}
	
	// DB - Methods
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBase_cost() {
		return base_cost;
	}
	public void setBase_cost(double base_cost) {
		this.base_cost = base_cost;
	}
	public double getDb_Storage() {
		return Db_Storage;
	}
	public void setDb_Storage(double db_Storage) {
		Db_Storage = db_Storage;
	}
	public static int getCount() {
		return count;
	}
	
	public static void resetCount() {
		count = 0;
	}
	
	/*
	 * public static void setCount(int count) { DB.count = count; }
	 */	
	
	/*
	 * @Override public String toString() { return "DB [name=" + name +
	 * ", base_cost=" + base_cost + ", Db_Storage=" + Db_Storage + "]"; }
	 */
	
		
	public abstract double monthlyCost();	

	
	/*
	 * @Override public String toString() { return "DB [name=" + name +
	 * ", base_cost=" + base_cost + ", Db_Storage=" + Db_Storage + ", getName()=" +
	 * getName() + ", getBase_cost()=" + getBase_cost() + ", getDb_Storage()=" +
	 * getDb_Storage() + ", monthlyCost()=" + monthlyCost() + "]"; }
	 */
	
	@Override public String toString() {
		return name + "("+ getClass()  +")\n" + 
			   "Monthly Cost: "  +String.format("$%,.2f", monthlyCost())+"\n" +
			   "Storage: " + String.format("%.3f", getDb_Storage()) + " TB\n" + 
			   "Base Cost: " + String.format("$%,.2f", getBase_cost()) +"\n";
	}

	
	/*
	 * public void printCostFactor() { // TODO Auto-generated method stub
	 * 
	 * }
	 */
	
	public int compareTo(DB db) {
		
		/*
		 *  Takes a DB object as a parameter and returns an int indicating the results
		 *  of comparing the two DB objects based on their respective name fields
		 */
		
		return db.getName().compareTo(this.getName());
		
	}
}
