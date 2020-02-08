package model;

public class Eagle extends Bird {
  private String preyAnimal;

  public Eagle(int age, int weight, int flightSpeed, String preyAnimal) {
    super(age, weight, flightSpeed);
    this.preyAnimal = preyAnimal;
  }

  public Eagle() {
    super();
    this.preyAnimal = "rabbit";
  }

  public void prey() {
    System.out.printf("... prey (%s) ...\n", preyAnimal);
  }

  @Override
  public void eat() {
    System.out.printf("... eat (%s) ...\n", preyAnimal);
  }
}
