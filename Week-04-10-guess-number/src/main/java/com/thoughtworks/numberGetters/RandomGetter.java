package com.thoughtworks.numberGetters;

import java.util.Random;

public class RandomGetter implements NumberGetter {
  @Override
  public String guessNumbers() {
    StringBuilder distinctNumbers = new StringBuilder();
    Random random = new Random();
    while (distinctNumbers.length() < 4) {
      int number = random.nextInt(10);
      if (!distinctNumbers.toString().contains(String.valueOf(number))) {
        distinctNumbers.append(number);
      }
    }
    return distinctNumbers.toString();
  }
}
