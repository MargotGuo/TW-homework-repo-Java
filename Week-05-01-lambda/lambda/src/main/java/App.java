import java.util.function.Consumer;
import java.util.function.Function;

public class App {
    public static void main(String[] args) {
        String originalString = "test";
        invokeStringOperator(originalString, inputString -> "*******" + inputString + "*******");
        addStarByConsumer(originalString);

        int number = 3;
        int result1 = invokeNumberOperator(number, inputNumber -> inputNumber * inputNumber);
        int result2 = getSquareByFunction(number);
        System.out.println(result1);
        System.out.println(result2);
    }

    private static <T> void addStarByConsumer(T inputString) {
        Consumer<T> consumer = str -> System.out.println("*******" + str + "*******");
        consumer.accept(inputString);
    }

    private static <T> void invokeStringOperator(T originalInfo, StringOperator<T> operator) {
        System.out.println(operator.addStar(originalInfo));
    }

    private static int getSquareByFunction(int inputNumber) {
        Function<Integer, Integer> function = number -> number * number;
        return function.apply(inputNumber);
    }

    private static <T extends Number> T invokeNumberOperator(T number, NumberOperator<T> operator) {
        return operator.getSquare(number);
    }
}
