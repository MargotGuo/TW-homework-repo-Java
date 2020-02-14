package com.thoughtworks;

import java.text.ParseException;
import java.util.Set;

public class App {

  public static void main(String[] args) throws ParseException {
    Student ZhangSan = new Student("张三", "001", "2019.02.11");
    Student LiSi = new Student("李四", "002", "2019.02.10");
    Student WangWu = new Student("王五", "001", "2019.02.09");

    Teacher ZhangLong = new Teacher("张龙", new Student[] {ZhangSan, LiSi, WangWu});
    Set<Student> duplicateStudents = ZhangLong.checkDuplicates();
    duplicateStudents.forEach(System.out::println);
  }
}
