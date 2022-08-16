package projectDatabase;

public class Test {

    public static void main(String[] args) {
        CentralizedDB centralizedDB = new CentralizedDB("Database One", 1200, 5, 1500);
        DistributedDB distributedDB  = new DistributedDB("Database Two",  2000, 7.5, 100, 12);
        HomogeneousDB homogenousDB = new HomogeneousDB("Database Three",  2000, 7.5, 100, 14);
        HeterogeneousDB heterogenousDB = new HeterogeneousDB("Database Four", 2000,7.5, 100, 14);
        	
        System.out.println("=====================");
        System.out.println("DB.count \n" + DB.count + "\n");
        System.out.println("=====================");
     
        System.out.println(centralizedDB + "\n");
        System.out.println("=====================");
        System.out.println(distributedDB + "\n");
        System.out.println("=====================");
        System.out.println(homogenousDB + "\n");
        System.out.println("=====================");
        System.out.println(heterogenousDB + "\n");
        System.out.println("=====================");

    }	
}
