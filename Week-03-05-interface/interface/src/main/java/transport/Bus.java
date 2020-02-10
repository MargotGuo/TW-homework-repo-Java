package transport;

public class Bus implements Transportation {
  @Override
  public boolean isEnough(int money) {
    return money >= 300;
  }
}
