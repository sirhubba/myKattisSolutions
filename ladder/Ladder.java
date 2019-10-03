import java.util.Scanner;

public class Ladder{

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int h = sc.nextInt();
    int v = sc.nextInt();

    double x = Math.toRadians(v);
    int ladderLength = (int) Math.ceil(h/Math.sin(x));
    System.out.println(ladderLength);

  }
}
