package projectDatabasePart2;

import java.io.File;
import java.io.FileNotFoundException;

public class DBPart2 {

	public static void main(String[] args) throws FileNotFoundException {
		DBList dbList =  new DBList();
		dbList.readFile("src/data_folder/dbFile1.csv");
		dbList.generateReport();
		dbList.generateReportByName();
		dbList.generateReportByMonthlyCost();
	}
}
