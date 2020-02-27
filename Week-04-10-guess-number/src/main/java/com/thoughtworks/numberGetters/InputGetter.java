package com.thoughtworks.numberGetters;

import java.util.Scanner;

public class InputGetter implements NumberGetter {
  @Override
  public String guessNumbers() {
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }
}
