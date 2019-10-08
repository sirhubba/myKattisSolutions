import java.util.Scanner;

public class SpeedLimit{
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    boolean continueDialog = true;
    int totalDistance = 0;

    while (continueDialog){

      int inputSize = sc.nextInt();
      if(inputSize == -1){
        System.exit(0);
      }
      int mph = 0, totalTime = 0, previousTime = 0, timeInterval = 0,
        distanceTraveled = 0;

      for (int i=0; i<inputSize; i++) {

        mph = sc.nextInt();
        previousTime = totalTime;
        totalTime = sc.nextInt();
        timeInterval = totalTime - previousTime;

        distanceTraveled = mph * timeInterval;
        totalDistance = totalDistance + distanceTraveled;

      }

      System.out.println(totalDistance + " miles");
      totalDistance = 0;

    }
  }
}
