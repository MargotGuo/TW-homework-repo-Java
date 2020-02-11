package com.direction;

public class North extends Direction {
  {
    setDirection('N');
  }

  @Override
  public Direction turnLeft() {
    return new West();
  }

  @Override
  public Direction turnRight() {
    return new East();
  }
}
