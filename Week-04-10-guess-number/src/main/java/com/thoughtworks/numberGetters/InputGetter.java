package com.thoughtworks.numberGetters;

import java.util.Scanner;

public class InputGetter implements NumberGetter {
  @Override
  public String getNumbers() {
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }
}
