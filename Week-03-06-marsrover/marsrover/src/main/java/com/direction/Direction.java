package com.direction;

public abstract class Direction {
  private char direction;

  public void setDirection(char direction) {
    this.direction = direction;
  }

  public abstract Direction turnLeft();

  public abstract Direction turnRight();

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Direction direction1 = (Direction) o;

    if (direction != direction1.direction) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return (int) direction;
  }

  @Override
  public String toString() {
    return "Direction{direction=" + direction + '}';
  }

}
