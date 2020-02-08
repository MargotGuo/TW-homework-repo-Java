package model;

public class Bird extends Animal {
  private int flightSpeed;  // in km/h

  public Bird(int age, int weight, int flightSpeed) {
    super(age, weight);
    this.flightSpeed = flightSpeed;
  }

  public Bird() {
    super();
    this.flightSpeed = 50;
  }

  public void fly() {
    System.out.printf("... fly (%d km/h) ...\n", flightSpeed);
  }
}
