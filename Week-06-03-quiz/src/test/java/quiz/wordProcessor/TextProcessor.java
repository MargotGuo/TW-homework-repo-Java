package quiz.wordProcessor;

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

    StringBuilder result = new StringBuilder();
    String[] words = splitToWordArray(text);

    int currentLength = 0;
    for (String word : words) {
      String lineInformation = getLineInformation(currentLength, word.length(), settings.getWidth());
      currentLength += word.length();
      result.append(String.format("%s%s;", word, lineInformation));
    }
    return result.toString();
    // --end-->
  }

  private String[] splitToWordArray(String text) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < text.length() - 1; i++) {
      stringBuilder.append(text.charAt(i));
      if ((text.charAt(i) == ' ' && text.charAt(i + 1) != ' ') ||
          (text.charAt(i) != ' ' && text.charAt(i + 1) == ' ')) {
        stringBuilder.append("my_separator");
      }
    }
    stringBuilder.append(text.charAt(text.length() - 1));
    return stringBuilder.toString().split("my_separator");
  }

  private String getLineInformation(int currentLength, int length, int width) {

    int startLine = (currentLength + 1) % width == 0 ?
        (currentLength + 1) / width : (currentLength + 1) / width + 1;
    int endLine = ((currentLength + length) % width) == 0 ?
        ((currentLength + length) / width) : ((currentLength + length) / width) + 1;

    String lineInformation;
    if (endLine - startLine == 0) {
      lineInformation = String.format("(%s)", endLine);
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      for (int i = startLine; i <= endLine; i++) {
        stringBuilder.append(i).append(",");
      }
      stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
      lineInformation = String.format("(%s)", stringBuilder.toString());
    }
    return lineInformation;
  }

}

