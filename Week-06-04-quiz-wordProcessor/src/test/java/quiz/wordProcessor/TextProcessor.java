package quiz.wordProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class TextProcessor {
  private final TextProcessorSettings settings;

  TextProcessor(int width) {
    this(width, null);
  }

  TextProcessor(int width, char[] whitespaces) {
    if (width < 10 || width > 80) {
      throw new IllegalArgumentException("Width out of range.");
    }

    settings = new TextProcessorSettings(width, getWhitespaces(whitespaces));
  }

  private char[] getWhitespaces(char[] whitespaces) {
    return whitespaces == null ?
        new char[]{' '} :
        whitespaces;
  }

  String process(String text) {
    // TODO: Please implement the method to pass all the test
    // <--start
    if (text == null) {
      throw new IllegalArgumentException();
    }
    AtomicInteger textLength = new AtomicInteger();
    return splitTextToList(text).stream()
        .map(word -> String.format("%s(%s);", word, getLineDetail(textLength.addAndGet(word.length()), word.length())))
        .collect(Collectors.joining(""));
    // --end-->
  }

  private List<String> splitTextToList(String text) {
    List<String> wordList = new ArrayList<>();
    int startFlag = 0;
    for (int i = 1; i < text.length(); i++) {
      if (settings.isWhitespace(text.charAt(i - 1)) != settings.isWhitespace(text.charAt(i))) {
        wordList.add(text.substring(startFlag, i));
        startFlag = i;
      }
    }
    wordList.add(text.substring(startFlag));
    return wordList;
  }

  private String getLineDetail(int sentenceLength, int wordLength) {
    int startLine = locateLine(sentenceLength - wordLength + 1);
    int endLine = locateLine(sentenceLength);
    return IntStream.range(startLine, endLine + 1)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(","));
  }

  private int locateLine(int totalLength) {
    int width = settings.getWidth();
    return (int) Math.ceil(totalLength * 1.0 / width);
  }
}

