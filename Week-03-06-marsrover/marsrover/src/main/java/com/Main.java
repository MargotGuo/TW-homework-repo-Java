package com;

import com.direction.Directions;

public class Main {
  public static void main(String[] args) {
    Directions west = Directions.WEST;
    System.out.println(west);

    Directions south = west.turnLeft();
    System.out.println(south);

    Directions north = west.turnRight();
    System.out.println(north);

    System.out.println(west.equals(south));
    System.out.println(west.equals(Directions.WEST));
  }
}
