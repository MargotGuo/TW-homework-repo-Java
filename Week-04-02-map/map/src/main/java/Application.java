import java.util.List;
import java.util.Map;

public class Application {

  public static void main(String[] args) {
    Teacher teacherBob = new Teacher("Bob",
        new Student("Linda", 18),
        new Student("Cindy", 19),
        new Student("Mary", 19));
    teacherBob.addStudent(new Student("Ben", 19));
    teacherBob.addStudent(new Student("Solider", 20));

    Map<Integer, List<Student>> studentMap = teacherBob.getStudentMap();
    for (int age : studentMap.keySet()) {
      System.out.printf("Age at %s:\n", age);
      studentMap.get(age).forEach(System.out::println);
    }
  }
}
