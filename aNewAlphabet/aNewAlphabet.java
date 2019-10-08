import java.util.Scanner;

public class aNewAlphabet{
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    //Read a line from the scanner and split every character into an array.
    String line = sc.nextLine().toLowerCase();
    String[] splitString = line.split("");
    StringBuilder sb = new StringBuilder();

    //for each character in the input line add it to the new output string
    //with the modified character.
    for (String s : splitString) {
      //System.out.println(newSymbol(s));
      sb.append(newSymbol(s));
    }

    System.out.println(sb);

  }

  //Method to manipulate character into a new one if it's letters a-z.
  public static String newSymbol(String lowerCaseChar){

    String output;

    switch(lowerCaseChar){
      default: output = lowerCaseChar;
      break;
      case "a": output = "@";
      break;
      case "b": output = "8";
      break;
      case "c": output = "(";
      break;
      case "d": output = "|)";
      break;
      case "e": output = "3";
      break;
      case "f": output = "#";
      break;
      case "g": output = "6";
      break;
      case "h": output = "[-]";
      break;
      case "i": output = "|";
      break;
      case "j": output = "_|";
      break;
      case "k": output = "|<";
      break;
      case "l": output = "1";
      break;
      case "m": output = "[]\\/[]";
      break;
      case "n": output = "[]\\[]";
      break;
      case "o": output = "0";
      break;
      case "p": output = "|D";
      break;
      case "q": output = "(,)";
      break;
      case "r": output = "|Z";
      break;
      case "s": output = "$";
      break;
      case "t": output = "']['";
      break;
      case "u": output = "|_|";
      break;
      case "v": output = "\\/";
      break;
      case "w": output = "\\/\\/";
      break;
      case "x": output = "}{";
      break;
      case "y": output = "`/";
      break;
      case "z": output = "2";
      break;
    }
    return output;
  }
}
