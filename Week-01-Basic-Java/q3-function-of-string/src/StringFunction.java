public class StringFunction {
  public static void main(String[] args) {
    String s = "Margot is sleepy...";

    System.out.println("原字符串: " + s);
    System.out.println("length测试结果: " + s.length());
    System.out.println("indexOf 'e' 的测试结果: " + s.indexOf("e"));
    System.out.println("charAt 4 的测试结果: " + s.charAt(4));
    System.out.println("startWith 'M' 的测试结果: " + s.startsWith("M"));
    System.out.println("endsWith 'a' 的测试结果: " + s.endsWith("a"));
    System.out.println("subString(15, 18) 的测试结果: " + s.substring(15,18));
  }
}
