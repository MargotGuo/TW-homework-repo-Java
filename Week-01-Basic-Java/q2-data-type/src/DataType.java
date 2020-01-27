public class DataType {
  private byte aByte = 1;
  private short aShort = 1;
  private int anInt = 1;
  private long aLong = 1;
  private float aFloat = 1;
  private double aDouble = 1;
  private boolean aBoolean = false;
  private char aChar = 'a';

  public void print() {
    System.out.println("byte: " + aByte);
    System.out.println("short: " + aShort);
    System.out.println("int: " + anInt);
    System.out.println("long: " + aLong);
    System.out.println("float: " + aFloat);
    System.out.println("double: " + aDouble);
    System.out.println("boolean: " + aBoolean);
    System.out.println("char: " + aChar);
  }

  public static void main(String[] args) {
    DataType dataType = new DataType();
    dataType.print();
  }
}
