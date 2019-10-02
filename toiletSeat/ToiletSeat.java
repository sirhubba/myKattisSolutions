import java.util.Scanner;
import java.util.ArrayList;

public class ToiletSeat{
  public static void main(String[] args) {

    //Read input line in single string
    Scanner sc = new Scanner(System.in);
    String line = sc.nextLine();

    ArrayList<String> input = new ArrayList<String>();

    //Split input line into separate characters and add to ArrayList
    String[] splitString = line.split("(?!^)");
    for (String s : splitString) {
      //System.out.println(s);
      input.add(s);
    }

    boolean continueDialog = true;
    boolean seatStart = false;
    int p1 = 0;
    int p2 = 0;
    int p3 = 0;

    while(continueDialog) {

      //Check first character to see if toilet seat starts up or down
      String startPosition = input.get(0);
      if(startPosition.equals("U")){
        seatStart = true;
        input.remove(0);
      }else if(startPosition.equals("D")){
        seatStart = false;
        input.remove(0);
      }else{
        System.out.println("Invalid input, please only enter characters 'U' and 'D'");
        System.exit(0);
      }

      boolean seatUp = seatStart;

      //For each remaining character in the input line, calculate number of
      //changes that has to be made for policy 1.
      for (String s : input) {
        if(s.equals("U")){
          if(seatUp == true){ }
          if(seatUp == false){ p1 = p1 + 1; seatUp = true; }
        }else if(s.equals("D")){
          if(seatUp == true){ p1 = p1 + 2; }
          if(seatUp == false){ p1 = p1 + 1; seatUp = true; }
        }else{
          System.out.println("Invalid input, please only enter characters 'U' and 'D'");
        }
      }
      seatUp = seatStart;

      //For each remaining character in the input line, calculate number of
      //changes that has to be made for policy 2.
      for (String s : input) {
        if(s.equals("U")){
          if(seatUp == false){ p2 = p2 + 2; }
          if(seatUp == true){ p2 = p2 + 1; seatUp = false; }
        }else if(s.equals("D")){
          if(seatUp == true){ p2 = p2 + 1; seatUp = false; }
          if(seatUp == false){ }
        }else{
          System.out.println("Invalid input, please only enter characters 'U' and 'D'");
        }
      }
      seatUp = seatStart;

      //For each remaining character in the input line, calculate number of
      //changes that has to be made for policy 3.
      for (String s : input) {
        if(s.equals("U")){
          if(seatUp == true){ }
          if(seatUp == false){ p3 = p3 + 1; seatUp = true; }
        }else if(s.equals("D")){
          if(seatUp == false){ }
          if(seatUp == true){ p3 = p3 + 1; seatUp = false; }
        }else{
          System.out.println("Invalid input, please only enter characters 'U' and 'D'");
        }
      }
      //Print result for each policy.
      System.out.println(p1);
      System.out.println(p2);
      System.out.println(p3);
      //To not trigger infinite loops
      continueDialog = false;
    }
  }
}
