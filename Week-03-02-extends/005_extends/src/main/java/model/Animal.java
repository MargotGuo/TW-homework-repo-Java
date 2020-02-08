package model;

public class Animal {
  private int age;
  private int weight; // in kg

  public Animal(int age, int weight) {
    this.age = age;
    this.weight = weight;
  }

  public Animal() {
    this.age = 0;
    this.weight = 5;
  }

  public void eat() {
    System.out.println("... eat ...");
  }

  public void sleep() {
    System.out.println("... sleep ...");
  }
}
