package com.thoughtworks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
  private String name;
  private String id;
  private Date admissionDate;

  public Student(String name, String id, String dateString) throws ParseException {
    this.name = name;
    this.id = id;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
    this.admissionDate = simpleDateFormat.parse(dateString);
  }

  @Override
  public String toString() {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("y年M月d日");
    String dateString = simpleDateFormat.format(admissionDate);
    int time = (int) ((new Date().getTime() - admissionDate.getTime()) / 1000 / 60 / 60 / 24 / 365);
    return String.format("我叫%s，我的学号是%s，%s入学，学龄%s年", name, id, dateString, time);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Student student = (Student) o;
    return id.equals(student.id);
  }
}
