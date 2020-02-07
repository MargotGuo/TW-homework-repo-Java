import model.Student;
import model.Teacher;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        Student LiLi = new Student("Li Li", 20, "female");
        System.out.println(String.format("%s, %s, %d years old", LiLi.name, LiLi.gender, LiLi.age));
        LiLi.study();
        LiLi.rest();

        Teacher ZhangLong = new Teacher("Zhang Long", new Student[] {
            new Student("Li Li", 20, "female"),
            new Student("Wang Qi", 21, "male")});
        ZhangLong.addNewStudent(new Student("Zhao Yi", 22, "male"));
        ZhangLong.getAllStudent();
    }
}
