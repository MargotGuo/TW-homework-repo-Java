package transport;

public class Train implements Transportation {
  @Override
  public boolean isEnough(int money) {
    return money >= 400;
  }
}
