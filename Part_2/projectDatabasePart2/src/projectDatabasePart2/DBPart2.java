package projectDatabasePart2;

import java.io.File;
import java.io.FileNotFoundException;

public class DBPart2 {

	public static void main(String[] args) throws FileNotFoundException {
		DBList dbList =  new DBList();
		File currentDirectory = new File("dbFile.csv");
		//dbList.readFile("dbFile.csv");
		dbList.generateReport();
		dbList.generateReportByName();
		dbList.generateReportByMonthlyCost();
	}
}
