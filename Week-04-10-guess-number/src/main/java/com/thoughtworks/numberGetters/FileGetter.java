package com.thoughtworks.numberGetters;

import com.thoughtworks.exception.WrongInputException;
import com.thoughtworks.appUtils.FormatChecker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileGetter implements NumberGetter {

  private File resourceFile;

  public FileGetter(String resourceFilePath) {
    this.resourceFile = new File(resourceFilePath);
  }

  @Override
  public String guessNumbers() {
    String numbers;
    try {
      BufferedReader bufferedReader = new BufferedReader(new FileReader(resourceFile));
      numbers = bufferedReader.readLine();
      FormatChecker.checkFormat(numbers);
    } catch (IOException | WrongInputException e) {
      numbers = new RandomGetter().guessNumbers();
    }
    return numbers;
  }
}
