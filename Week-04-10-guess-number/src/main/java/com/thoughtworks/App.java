package com.thoughtworks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    String answer = NumberUtil.getRandomNumber();
    String currentTry = getGuessNumberFromFile();

    StringBuilder stringBuilder = new StringBuilder(Calculator.getOutput(currentTry, answer));
    System.out.print(stringBuilder);
    int count = 1;

    Scanner scanner = new Scanner(System.in);
    while (count < 6 && !currentTry.equals(answer)) {
      currentTry = scanner.nextLine();
      try {
        NumberUtil.checkFormat(currentTry);
        stringBuilder.append(Calculator.getOutput(currentTry, answer));
        count++;
      } catch (WrongInputException e) {
        stringBuilder.append(String.format("%s Wrong input\n", currentTry));
      }
      System.out.print(stringBuilder);
    }

    if (count == 6 && !currentTry.equals(answer)) {
      System.out.printf("Unfortunately, you have no chance, the answer is %s!", answer);
    } else {
      System.out.println("Congratulations, you win!");
    }
  }

  private static String getGuessNumberFromFile() {
    String currentTry;
    try {
      BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\main\\resources\\answer.txt"));
      currentTry = bufferedReader.readLine();
      NumberUtil.checkFormat(currentTry);
    } catch (IOException | WrongInputException e) {
      currentTry = NumberUtil.getRandomNumber();
    }
    return currentTry;
  }
}
