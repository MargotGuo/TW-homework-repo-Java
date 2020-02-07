package model;

public class Student {
  public String name;
  public int age;
  public String gender;

  public Student(String name, int age, String gender) {
    this.name = name;
    this.age = age;
    this.gender = gender;
  }

  public void study() {
    System.out.println("study!!!");
  }

  public void rest() {
    System.out.println("rest...");
  }
}
