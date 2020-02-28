package com.thoughtworks;

import com.thoughtworks.exception.WrongInputException;
import com.thoughtworks.numberGetters.NumberGetter;
import com.thoughtworks.numberGetters.FileGetter;
import com.thoughtworks.numberGetters.InputGetter;
import com.thoughtworks.appUtils.Calculator;
import com.thoughtworks.appUtils.FormatChecker;

public class App {

  public static void main(String[] args) {
    // initialize answer
    NumberGetter fileGetter = new FileGetter("src\\main\\resources\\answer.txt");
    String answer = fileGetter.getNumbers();

    String currentGuess = "";
    StringBuilder output = new StringBuilder();

    // guess from input
    int count = 0;
    NumberGetter inputGetter = new InputGetter();
    while (count < 6 && !currentGuess.equals(answer)) {
      currentGuess = inputGetter.getNumbers();
      try {
        FormatChecker.checkFormat(currentGuess);
        output.append(String.format("%s %s\n", currentGuess, Calculator.getResult(currentGuess, answer)));
        count++;
      } catch (WrongInputException e) {
        output.append(String.format("%s Wrong input\n", currentGuess));
      }
      System.out.print(output);
    }

    // print result
    if (count == 6 && !currentGuess.equals(answer)) {
      System.out.printf("Unfortunately, you have no chance, the answer is %s!", answer);
    } else {
      System.out.println("Congratulations, you win!");
    }
  }
}
