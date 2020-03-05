import java.util.function.Consumer;
import java.util.function.Function;

public class App {
  public static void main(String[] args) {
    String originalString = "test";
    invokeStarGenerator(originalString, str -> System.out.println("*******" + str + "*******"));
    addStarByConsumer(originalString, str -> System.out.println("*******" + str + "*******"));

    int inputNumber = 3;
    int result1 = invokeCalculator(inputNumber, number -> number * number);
    int result2 = getSquareByFunction(inputNumber, number -> number * number);
    System.out.println(result1);
    System.out.println(result2);
  }

  private static void invokeStarGenerator(String inputString, StarGenerator<String> starGenerator) {
    starGenerator.addStar(inputString);
  }

  private static void addStarByConsumer(String inputString, Consumer<String> starGenerator) {
    starGenerator.accept(inputString);
  }

  private static int invokeCalculator(int inputNumber, Calculator<Integer> calculator) {
    return calculator.getSquare(inputNumber);
  }

  private static int getSquareByFunction(int inputNumber, Function<Integer, Integer> calculator) {
    return calculator.apply(inputNumber);
  }
}
