import java.util.function.Consumer;
import java.util.function.Function;

public class App {
  public static void main(String[] args) {
    String originalString = "test";
    invokeStringOperator(originalString, str -> System.out.println("*******" + str + "*******"));
    addStarByConsumer(originalString, str -> System.out.println("*******" + str + "*******"));

    int inputNumber = 3;
    int result1 = invokeNumberOperator(inputNumber, number -> number * number);
    int result2 = getSquareByFunction(inputNumber, number -> number * number);
    System.out.println(result1);
    System.out.println(result2);
  }

  private static void invokeStringOperator(String inputString, StringOperator<String> stringOperator) {
    stringOperator.addStar(inputString);
  }

  private static void addStarByConsumer(String inputString, Consumer<String> consumer) {
    consumer.accept(inputString);
  }

  private static int invokeNumberOperator(int inputNumber, NumberOperator<Integer> numberOperator) {
    return numberOperator.getSquare(inputNumber);
  }

  private static int getSquareByFunction(int inputNumber, Function<Integer, Integer> function) {
    return function.apply(inputNumber);
  }
}
