package transport;

public class Aircraft implements Transportation {
  @Override
  public boolean isEnough(int money) {
    return money >= 1000;
  }
}
