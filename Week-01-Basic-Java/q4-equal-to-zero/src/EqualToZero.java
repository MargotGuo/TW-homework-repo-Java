import java.util.Scanner;

public class EqualToZero {

  public static boolean equalToZero(double number) {
    return Math.abs(number) < 1e-15;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    double input = in.nextDouble();
    System.out.println(equalToZero(input));
  }
}
