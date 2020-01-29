import java.util.Scanner;

public class Sort {

  private static void sort(int x, int y, int z) {
    int[] array = {x, y, z};
    for (int j = array.length; j > 0; j--) {
      for (int i = 0; i < j - 1; i++) {
        if (array[i] > array[i + 1]) {
          int temp = array[i];
          array[i] = array[i + 1];
          array[i + 1] = temp;
        }
      }
    }
    for (int number : array) {
      System.out.print(number + " ");
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int x = in.nextInt();
    int y = in.nextInt();
    int z = in.nextInt();
    sort(x, y, z);
  }
}
