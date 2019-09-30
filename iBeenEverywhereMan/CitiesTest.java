import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CitiesTest{

  public static void main(String[] args) {

    Scanner           sc             = new Scanner(System.in);
    ArrayList<String> testCaseCities = new ArrayList<String>();
    int testCases = sc.nextInt();
    //System.out.println("Number of test cases: " + testCases);
    while(testCases != 0){
      int numberOfTrips = sc.nextInt();
      //System.out.println("Number of trips in this test case: " + numberOfTrips);

      for(int i = 0; i < numberOfTrips; i++){
        testCaseCities.add(sc.next());
      }
      //System.out.println(testCaseCities.size());
      /*for (String s : testCaseCities) {
        System.out.println(s.toString());
      }*/
      //Use Set to only print out cities once.
      Set<String> uniqueCities = new HashSet<String>(testCaseCities);
      System.out.println(uniqueCities.size());
      testCaseCities.clear();
      uniqueCities.clear();
      testCases--;

    }
  }
}
