package com.direction;

public class East extends Direction {
  {
    setDirection('E');
  }

  @Override
  public Direction turnLeft() {
    return new North();
  }

  @Override
  public Direction turnRight() {
    return new South();
  }
}
