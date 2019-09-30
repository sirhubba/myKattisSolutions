import java.io.*;
import java.util.ArrayList;

public class PolishNotationTest{
  public static void main(String[] args) {

    int cases = 1;
    ArrayList<String> input = new ArrayList<String>();
    StringBuilder sb = new StringBuilder();

    try{
      BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in));
      String line = null;
      while((line = reader.readLine()) != null){
          String[] splitString = line.split(" ");

        for (String s : splitString) {
          //System.out.println(s.length());
          input.add(s);
        }

        boolean continueDialog = true;

        while(continueDialog) {
          //To not trigger infinite loops
          continueDialog = false;
          //For each string in the list, check if it's an operator followed by
          //2 operands.
          for(int i = 0; i < input.size()-2; i++) {
            String char0 = input.get(i);
            String char1 = input.get(i+1);
            String char2 = input.get(i+2);

            if (char0.equals("+") || char0.equals("*") || char0.equals("-")) {
              if (isInteger(char1,10) && isInteger(char2,10)) {
                //If all these checks passes we can remove the next 2 strings
                //since we know they are operands and not operators.
                input.remove(i+1);
                input.remove(i+1);
                //Trigger the loop again.
                continueDialog = true;
                //In case (no pun intended) we want to add more operators, the
                //switch case statements will make it easier and cleaner.
                //If char0 is x operator perform y operation
                switch(char0) {
                  case "+":
                    input.set(i, Integer.parseInt(char1)+Integer.parseInt(char2)+"");
                    break;
                  case "*":
                    input.set(i, Integer.parseInt(char1)*Integer.parseInt(char2)+"");
                    break;
                  case "-":
                    input.set(i, Integer.parseInt(char1)-Integer.parseInt(char2)+"");
                    break;
                }
              }
            }
          }
        }

        for (String s : input) {
          sb.append(" " + s);
        }
        System.out.println("Case " + cases + ":" + sb.toString()/*input.get(0)*/);
        //Reset everything and start over with next case.
        input.clear();
        sb.setLength(0);
        cases++;
      }
    }catch(IOException ioe){
      System.out.println("Error reading: " + ioe.getMessage());
    }
  }

  //Check if a string could be a number, if the method returns true we can
  //parse the string into an int.
  public static boolean isInteger(String s, int radix) {
      if(s.isEmpty()) return false;
      for(int i = 0; i < s.length(); i++) {
          //Check if number is negative
          if(i == 0 && s.charAt(i) == '-') {
              //Make sure it's actually a number and not an operator
              if(s.length() == 1) return false;
              else continue;
          }
          //Anything other than a number will return false
          if(Character.digit(s.charAt(i),radix) < 0) return false;
      }
      return true;
  }
}
