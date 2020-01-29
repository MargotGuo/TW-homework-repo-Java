public class EndLoop {
  private static void breakLoop() {
    for (int i = 0; i < 5; i++) {
      if (i == 2) {
        break;
      }
      System.out.print(i);
    }
    System.out.println();
  }

  private static void continueLoop() {
    for (int i = 0; i < 5; i++) {
      if (i == 2) {
        continue;
      }
      System.out.print(i);
    }
    System.out.println();
  }


  public static void main(String[] args) {
    breakLoop();
    continueLoop();
  }
}
