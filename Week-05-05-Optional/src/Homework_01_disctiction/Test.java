package Homework_01_disctiction;

import java.util.Optional;

public class Test {
  public static void main(String[] args) {
    System.out.println("==== use orElse and the wrapped value is null ====");
    boolean result1 = isEqualToDefaultByOrElse(null);
    System.out.println(result1);

    System.out.println("==== use orElseGet and the wrapped value is null ====");
    boolean result2 = isEqualToDefaultByOrElseGet(null);
    System.out.println(result2);

    System.out.println("==== use orElse and the wrapped value is not null ====");
    boolean result3 = isEqualToDefaultByOrElse("aaa");
    System.out.println(result3);

    System.out.println("==== use orElseGet and the wrapped value is not null ====");
    boolean result4 = isEqualToDefaultByOrElseGet("aaa");
    System.out.println(result4);
    // 不调用getDefaultValue方法
  }

  public static String getDefaultValue() {
    // 通过是否打印"Getting Default Value"判断是否调用getDefaultValue方法
    System.out.println("Getting Default Value");
    return "Default Value";
  }

  public static boolean isEqualToDefaultByOrElse(String text) {
    String result = Optional.ofNullable(text).orElse(getDefaultValue());
    return result.equals("Default Value");
  }

  public static boolean isEqualToDefaultByOrElseGet(String text) {
    String result = Optional.ofNullable(text).orElseGet(Test::getDefaultValue);
    return result.equals("Default Value");
  }
}
