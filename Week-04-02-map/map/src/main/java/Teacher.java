import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Teacher {
  private String name;
  private Map<Integer, List<Student>> studentMap = new HashMap<>();

  public Teacher(String name, Student...students) {
    this.name = name;
    for (Student student : students) {
      addStudent(student);
    }
  }

  public void addStudent(Student student) {
    int age = student.getAge();
    if (!studentMap.containsKey(age)) {
      studentMap.put(age, new LinkedList<>());
    }
    studentMap.get(age).add(student);
  }

  public Map<Integer, List<Student>> getStudentMap() {
    return studentMap;
  }
}
