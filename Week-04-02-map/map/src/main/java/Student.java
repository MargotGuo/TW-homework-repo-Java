public class Student {

  private String name;
  private int age;

  public Student(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public int getAge() {
    return age;
  }

  @Override
  public String toString() {
    return String.format("name: %s, age: %s", name, age);
  }
}
