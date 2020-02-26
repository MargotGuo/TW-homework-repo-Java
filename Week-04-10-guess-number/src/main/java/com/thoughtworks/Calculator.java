package com.thoughtworks;

public class Calculator {

  private Calculator() {}

  public static String getOutput(String currentTry, String answer) {
    int correctNumber = 0;
    int correctButNotRightSite = 0;
    for (int i = 0; i < currentTry.length(); i++) {
      if (answer.contains(String.valueOf(currentTry.charAt(i)))) {
        if (answer.charAt(i) == currentTry.charAt(i)) {
          correctNumber++;
        } else {
          correctButNotRightSite++;
        }
      }
    }
    return String.format("%s %sA%sB\n", currentTry, correctNumber, correctButNotRightSite);
  }
}
