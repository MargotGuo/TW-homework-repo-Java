package com.thoughtworks;

import java.util.Set;
import java.util.LinkedHashSet;

public class Teacher {
  private String name;
  private Student[] students;

  public Teacher(String name, Student[] students) {
    this.name = name;
    this.students = students;
  }

  public Set<Student> checkDuplicates() {
    Set<Student> duplicateStudents = new LinkedHashSet<>();
    for (int i = 0; i < students.length; i++) {
      for (int j = i + 1; j < students.length; j++) {
        if(students[i].equals(students[j])) {
          duplicateStudents.add(students[i]);
          duplicateStudents.add(students[j]);
        }
      }
    }
    return duplicateStudents;
  }
}
