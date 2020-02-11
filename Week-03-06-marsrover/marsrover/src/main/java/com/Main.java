package com;

import com.direction.Direction;
import com.direction.West;

public class Main {
  public static void main(String[] args) {
    Direction west = new West();
    System.out.println(west);  // Direction{direction=W}

    Direction south = west.turnLeft();
    System.out.println(south);  // Direction{direction=S}

    Direction north = west.turnRight();
    System.out.println(north);  // Direction{direction=N}

    System.out.println(west.equals(south));       // false
    System.out.println(west.equals(new West()));  // true
  }
}
