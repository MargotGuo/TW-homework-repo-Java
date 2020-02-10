package transport;

public class Car implements Transportation {
  @Override
  public boolean isEnough(int money) {
    return money >= 500;
  }
}
