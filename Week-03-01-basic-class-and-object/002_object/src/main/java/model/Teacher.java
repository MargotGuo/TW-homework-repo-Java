package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Teacher {
  public String name;
  public Student[] myStudent;

  public Teacher(String name, Student[] myStudent) {
    this.name = name;
    this.myStudent = myStudent;
  }

  public void getAllStudent() {
    for(int i = 0; i < myStudent.length; i++) {
      System.out.println(String.format("Student %d: %s, %s, %d years old.",
          i + 1, myStudent[i].name, myStudent[i].gender, myStudent[i].age));
    }
  }

  public void addNewStudent(Student newStudent) {
    List<Student> studentList = new ArrayList<Student>(Arrays.asList(myStudent));
    studentList.add(newStudent);
    myStudent = studentList.toArray(new Student[0]);
  }
}
