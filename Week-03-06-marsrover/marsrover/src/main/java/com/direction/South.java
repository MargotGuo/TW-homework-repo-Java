package com.direction;

public class South extends Direction {
  {
    setDirection('S');
  }

  @Override
  public Direction turnLeft() {
    return new East();
  }

  @Override
  public Direction turnRight() {
    return new West();
  }
}
