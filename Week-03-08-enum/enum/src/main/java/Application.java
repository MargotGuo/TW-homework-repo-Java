public class Application {

  public static void main(String[] args) {
    for(Student student : Student.values()) {
      if(student.getGender().equals("Female")) {
        System.out.printf("name: %s, gender: %s\n", student.getName(), student.getGender());
      }
    }
  }

}
