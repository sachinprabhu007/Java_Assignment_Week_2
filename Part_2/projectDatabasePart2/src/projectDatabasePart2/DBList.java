package projectDatabasePart2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class DBList {

	//DBList - Fields
	
	private DB[] dbObjects;
	private String[] dbInvalidRecords;
	
	//DBList - Constructor
	
	public DBList() {
		dbObjects = new DB[0];
		dbInvalidRecords = new String[0];
	}

	
	//DBList - Methods

	public DB[] getDbObjects() {
		return dbObjects;
	}

	public String[] getDbInvalidRecords() {
		return dbInvalidRecords;
	}
	
	public void addDB(DB newElement)
	{
		dbObjects = Arrays.copyOf(dbObjects, dbObjects.length + 1);
		dbObjects[dbObjects.length - 1] = newElement;
	}
	
	public void addInvalidRecord(String str)
	{
		dbInvalidRecords = Arrays.copyOf(dbInvalidRecords, dbInvalidRecords.length + 1);
		dbInvalidRecords[dbInvalidRecords.length - 1] = str;
	}
	
	public void readFile(String fileName) throws FileNotFoundException
	{
		Scanner input = new Scanner(new File(fileName));
		input.useDelimiter(",");
		
		while(input.hasNext()) {
			String str = input.nextLine();
			String[] str_array = str.split(",");
		
		
			switch(str_array[0])
			{
				case "C":
				{
					CentralizedDB centralizedDB = new CentralizedDB(str_array[1], Double.parseDouble(str_array[2]), Double.parseDouble(str_array[3]), Double.parseDouble(str_array[4]));
					addDB(centralizedDB);
				}
				
				case "D":
				{
					DistributedDB distributedDB = new DistributedDB(str_array[1], Double.parseDouble(str_array[2]), Double.parseDouble(str_array[3]), Integer.parseInt(str_array[4]), Double.parseDouble(str_array[5]));
					addDB(distributedDB);
				}
								
				case "H":
				{
					HomogeneousDB homogeneousDB = new HomogeneousDB(str_array[1], Double.parseDouble(str_array[2]), Double.parseDouble(str_array[3]), Integer.parseInt(str_array[4]), Double.parseDouble(str_array[5]));
					addDB(homogeneousDB);
				}
				
				case "E":
				{
					HeterogeneousDB heterogeneousDB = new HeterogeneousDB(str_array[1], Double.parseDouble(str_array[2]), Double.parseDouble(str_array[3]), Integer.parseInt(str_array[4]), Double.parseDouble(str_array[5]));
					addDB(heterogeneousDB);
				}
				
				default:
				{
					addInvalidRecord(str);
					System.out.println("Default case");
				}
			}	
		}
		
	}
	
	public void generateReport()
	{
		System.out.println("============================");
		System.out.println("Monthly Database Report");
		System.out.println("============================");
		
		  DB[] db = getDbObjects();
		  Arrays.sort(getDbObjects());
		  for(int i = 0; i < db.length; i++) {
		  System.out.println(db[i].toString()); }
		 
		
	}
	
	public void generateReportByName()
	{
		System.out.println("==================================");
		System.out.println("Monthly Database Report (by Name) ");
		System.out.println("==================================");
		
		DB[] db = getDbObjects();
		Arrays.sort(getDbObjects(), new MonthlyCostComparator());
		for(int i = 0; i < db.length; i++) {
			System.out.println(db[i].toString());
		}
	}
	
	public void generateReportByMonthlyCost()
	{
		System.out.println("=========================================");
		System.out.println("Monthly Database Report (by Monthly Cost) ");
		System.out.println("=========================================");
		
		DB db[] = getDbObjects();
		for(int i = 0; i < db.length; i++) {
			System.out.println(db[i].toString());
		}
	}
}
