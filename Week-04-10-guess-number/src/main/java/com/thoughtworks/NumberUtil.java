package com.thoughtworks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomNumberUtil {

  private RandomNumberUtil() {
  }

  public static String getRandomNumber() {
    StringBuilder randomNumber = new StringBuilder();
    Random random = new Random();
    while (randomNumber.length() < 4) {
      int number = random.nextInt(10);
      if (!randomNumber.toString().contains(String.valueOf(number))) {
        randomNumber.append(number);
      }
    }
    return randomNumber.toString();
  }

  public static void checkFormat(String randomNumber) {
    Set<Character> distinctNumber = new HashSet<>();
    for (int i = 0; i < randomNumber.length(); i++) {
      distinctNumber.add(randomNumber.charAt(i));
    }
    if (distinctNumber.size() != 4) {
      throw new WrongInputException("Wrong input");
    }
  }
}
