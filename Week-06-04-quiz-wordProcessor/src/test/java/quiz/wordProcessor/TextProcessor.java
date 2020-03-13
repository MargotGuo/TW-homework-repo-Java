package quiz.wordProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
    AtomicInteger textLength = new AtomicInteger();
    return getWordList(text).stream()
        .map(word -> String.format("%s(%s);", word, getLineDetail(textLength.addAndGet(word.length()), word.length())))
        .collect(Collectors.joining(""));
    // --end-->
  }

  private List<String> getWordList(String text) {
    return Optional.ofNullable(text).map(sentence -> {
      List<String> wordList = new ArrayList<>();
      int startFlag = 0;
      for (int i = 1; i < sentence.length(); i++) {
        if (settings.isWhitespace(sentence.charAt(i - 1)) != settings.isWhitespace(sentence.charAt(i))) {
          wordList.add(sentence.substring(startFlag, i));
          startFlag = i;
        }
      }
      wordList.add(sentence.substring(startFlag));
      return wordList;
    }).orElseThrow(IllegalArgumentException::new);
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
    return totalLength % width == 0 ? totalLength / width : totalLength / width + 1;
  }
}

