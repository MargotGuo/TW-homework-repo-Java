package com.thoughtworks.appUtils;

import com.thoughtworks.exception.WrongInputException;

import java.util.HashSet;
import java.util.Set;

public class FormatChecker {
  public static void checkFormat(String numbers) {
    Set<Character> distinctNumber = new HashSet<>();
    for (int i = 0; i < numbers.length(); i++) {
      distinctNumber.add(numbers.charAt(i));
    }
    if (distinctNumber.size() != 4) {
      throw new WrongInputException("Wrong input");
    }
  }
}
