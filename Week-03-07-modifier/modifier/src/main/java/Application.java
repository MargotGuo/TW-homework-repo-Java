public class Application {

  public static void main(String[] args) {
    Student Cindy = new Student("Cindy", 80);
    Student Mary = new Student("Mary", 95);

    Teacher Solider = new Teacher("Solider", Mary);
    Teacher Bob = new Teacher("Bob", Cindy);

    System.out.println("====== before scores operation =======");
    System.out.printf("%s\n%s\n%s\n%s\n", Cindy, Mary, Solider, Bob);

    Solider.changeScore(5);
    Bob.changeScore(5);

    System.out.println("====== after scores operation =======");
    System.out.printf("%s\n%s\n%s\n%s\n", Cindy, Mary, Solider, Bob);
  }
}
