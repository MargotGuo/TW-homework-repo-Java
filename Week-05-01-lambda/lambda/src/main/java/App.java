import java.util.function.Consumer;
import java.util.function.Function;

public class App {
  public static void main(String[] args) {
    String originalString = "test";
    invokeStringOperator(originalString);
    addStarByConsumer(originalString);

    int number = 3;
    int result1 = invokeNumberOperator(number);
    int result2 = getSquareByFunction(number);
    System.out.println(result1);
    System.out.println(result2);
  }

  private static void invokeStringOperator(String inputString) {
    StringOperator<String> stringOperator = str -> System.out.println("*******" + str + "*******");
    stringOperator.addStar(inputString);
  }

  private static void addStarByConsumer(String inputString) {
    Consumer<String> consumer = str -> System.out.println("*******" + str + "*******");
    consumer.accept(inputString);
  }

  private static int invokeNumberOperator(int inputNumber) {
    NumberOperator<Integer> numberOperator = number -> number * number;
    return numberOperator.getSquare(inputNumber);
  }

  private static int getSquareByFunction(int inputNumber) {
    Function<Integer, Integer> function = number -> number * number;
    return function.apply(inputNumber);
  }
}
