import java.util.Scanner;

public class Test {
  private static void out(int aNumber) {
    if (aNumber == 0) {
      System.out.println("first string");
    } else if (aNumber > 0) {
      System.out.println("second string");
    }
    System.out.println("third string");
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    while (true) {
      int aNumber = in.nextInt();
      out(aNumber);
    }
  }
}
