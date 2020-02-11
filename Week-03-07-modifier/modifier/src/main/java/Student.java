public class Student {
  private final String name;
  int score;

  public Student(String name, int score) {
    this.name = name;
    this.score = score;
  }

  @Override
  public String toString() {
    return String.format("name: %s, score: %d", name, score);
  }
}
