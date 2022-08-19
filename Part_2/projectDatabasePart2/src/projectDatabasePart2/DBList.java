package projectDatabasePart2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
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
//		try {
//			
//			FileInputStream fstream = new FileInputStream(fileName);
//			DataInputStream dstream = new DataInputStream(fstream);
//			BufferedReader buffer_reader = new BufferedReader(new InputStreamReader(dstream));
//			String ip_str;
//		
//		
//		while((ip_str = buffer_reader.readLine()) != null)
//			{
//				System.out.println("Inside readFile");
//				Scanner input = new Scanner(ip_str);
//				input.useDelimiter(",");
			
		
		Scanner input = new Scanner(new File(fileName));
		input.useDelimiter(",");
		
		while(input.hasNext()) {
			String str = input.nextLine();
			String[] str_array = str.split(",");
		
		
			System.out.println("str---> " + str);	
			System.out.println("str_array[0] --->" + str_array[0]);
	
			switch(str_array[0])
			{
				case "C":
				{
					CentralizedDB centralizedDB = new CentralizedDB(str_array[1], Double.parseDouble(str_array[2]), Double.parseDouble(str_array[3]), Double.parseDouble(str_array[4]));
					addDB(centralizedDB);
					break;
				}
				
				case "D":
				{
					DistributedDB distributedDB = new DistributedDB(str_array[1], Double.parseDouble(str_array[2]), Double.parseDouble(str_array[3]), Integer.parseInt(str_array[4]), Double.parseDouble(str_array[5]));
					addDB(distributedDB);
					break;
				}
								
				case "H":
				{
					HomogeneousDB homogeneousDB = new HomogeneousDB(str_array[1], Double.parseDouble(str_array[2]), Double.parseDouble(str_array[3]), Integer.parseInt(str_array[4]), Double.parseDouble(str_array[5]));
					addDB(homogeneousDB);
					break;
				}
				
				case "E":
				{
					HeterogeneousDB heterogeneousDB = new HeterogeneousDB(str_array[1], Double.parseDouble(str_array[2]), Double.parseDouble(str_array[3]), Integer.parseInt(str_array[4]), Double.parseDouble(str_array[5]));
					addDB(heterogeneousDB);
					break;
				}
				
				default:
				{
					addInvalidRecord(str);
					System.out.println("Default case");
				}
				
//				input.close();
			}	
		}
	}
		
//		} //try block end
//		
//		catch (FileNotFoundException E){
//			System.out.println("Unable to find the file, Please check filename..");	
//		} 
//		catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Number format exception..");	
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("IO exception..");	
//			e.printStackTrace();
//		}
		
	
	
	public void generateReport()
	{
		System.out.println("============================");
		System.out.println("Monthly Database Report");
		System.out.println("============================");
		
		  DB[] db = getDbObjects();
		  for(int i = 0; i < db.length; i++) {
		  System.out.println(db[i].toString()); }
		 
		
	}
	
	public void generateReportByName()
	{
		System.out.println("==================================");
		System.out.println("Monthly Database Report (by Name) ");
		System.out.println("==================================");
		
		DB[] db = getDbObjects();
		Arrays.sort(getDbObjects());
		
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
		Arrays.sort(getDbObjects(), new MonthlyCostComparator());
		for(int i = 0; i < db.length; i++) {
			System.out.println(db[i].toString());
		}
	}
}
