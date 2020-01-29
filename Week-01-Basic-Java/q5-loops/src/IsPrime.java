import java.util.Scanner;

public class IsPrime {
  public static boolean isPrime(int number) {
    boolean flag = true;
    for (int i = 2; i <= Math.sqrt(number); i++) {
      if (number % i == 0) {
        flag = false;
        break;
      }
    }
    return flag;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int input = in.nextInt();
    System.out.println(isPrime(input));
  }
}
