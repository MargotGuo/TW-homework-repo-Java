package com.direction;

public class West extends Direction {
  {
    setDirection('W');
  }

  @Override
  public Direction turnLeft() {
    return new South();
  }

  @Override
  public Direction turnRight() {
    return new North();
  }
}
