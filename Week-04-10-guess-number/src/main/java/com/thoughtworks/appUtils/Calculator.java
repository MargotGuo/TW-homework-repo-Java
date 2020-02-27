package com.thoughtworks.appUtils;

public class Calculator {

  private Calculator() {}

  public static String getResult(String currentTry, String answer) {
    int correctNumber = 0;
    int correctButWrongSite = 0;
    for (int i = 0; i < currentTry.length(); i++) {
      if (answer.contains(String.valueOf(currentTry.charAt(i)))) {
        if (answer.charAt(i) == currentTry.charAt(i)) {
          correctNumber++;
        } else {
          correctButWrongSite++;
        }
      }
    }
    return String.format("%sA%sB", correctNumber, correctButWrongSite);
  }
}
