public class Main {

  public static void main(String[] args) {
    Object object1 = 1;
    System.out.println(canSupport(object1));

    Object object2 = 4.2;
    System.out.println(canSupport(object2));

    Object object3 = "3";
    System.out.println(canSupport(object3));
  }

  private static boolean canSupport(Object object) {
    if (!(object instanceof Number)) {
      try {
        throw new DataTypeNotSupported("Data Type Not Supported");
      } catch (DataTypeNotSupported dataTypeNotSupported) {
        dataTypeNotSupported.printStackTrace();
        return false;
      }
    }
    return true;
  }
}
