package projectDatabase;

public class CentralizedDB extends DB{

	// CentralizedDB - Field
	private double license;

	// CentralizedDB - Constructor
	public CentralizedDB(String name, double base_cost, double db_Storage, double license) {
		super(name, base_cost, db_Storage);
		this.license = license;
	}

	// CentralizedDB - Methods
	
	public double getLicense() {
		return license;
	}

	public void setLicense(double license) {
		this.license = license;
	}

	@Override
	public double monthlyCost() {
		// TODO Auto-generated method stub
		
		// Returns a double representing the monthly cost for the CentralizedDB 
		// calculated as the sum of base cost and license.
		return base_cost + license; 
	}

	@Override
	public String toString() {
		return super.toString() + "License: " + String.format("$%,.2f",getLicense());
	}

}
