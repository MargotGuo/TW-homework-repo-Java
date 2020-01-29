public class InfiniteLoop {
  private static void forLoop() {
    for (; ; ) {
      System.out.println("forLoop");
    }
  }

  private static void whileLoop() {
    while (true) {
      System.out.println("whileLoop");
    }
  }

  public static void main(String[] args) {
    whileLoop();
  }
}
