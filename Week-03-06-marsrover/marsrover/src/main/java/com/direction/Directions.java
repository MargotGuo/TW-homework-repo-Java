package com.direction;

public enum Directions {
  EAST('E', 'N', 'S'),
  WEST('W', 'S', 'N'),
  NORTH('N', 'W', 'E'),
  SOUTH('S', 'E', 'W');

  private char left;
  private char right;
  private char direction;

  Directions(char direction, char left, char right) {
    this.left = left;
    this.right = right;
    this.direction = direction;
  }

  public Directions turnLeft() {
    return getDirection(left);
  }

  public Directions turnRight() {
    return getDirection(right);
  }

  private Directions getDirection(char direction) {
    switch (direction) {
      case 'N':
        return Directions.NORTH;
      case 'S':
        return Directions.SOUTH;
      case 'W':
        return Directions.WEST;
      case 'E':
        return Directions.EAST;
      default:
        return null;
    }
  }

  @Override
  public String toString() {
    return "Direction{direction=" + direction + "}";
  }
}
