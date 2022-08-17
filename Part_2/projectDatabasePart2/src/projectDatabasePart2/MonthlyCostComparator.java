package projectDatabasePart2;

import java.util.Comparator;

public class MonthlyCostComparator implements Comparator<DB>{
	
	   public int compare(DB d1, DB d2) {
	        return (int) (d1.base_cost - d2.base_cost);
	    }

}
