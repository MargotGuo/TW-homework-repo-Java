package Homework_01_disctiction;
// 请比较orElse()和orElseGet()的详细区别。

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class MainTest {
  @Test
  public void whenOrElseWorks_thenCorrect() {
    String nullName = null;
    String name = Optional.ofNullable(nullName).orElse("john");
    assertEquals("john", name);
  }

  @Test
  public void whenOrElseGetWorks_thenCorrect() {
    String nullName = null;
    String name = Optional.ofNullable(nullName).orElseGet(() -> "john");
    assertEquals("john", name);
  }

  // To a lot of programmers who are new to Optional or Java 8,
  // the difference between orElse() and orElseGet() is not clear.
  // As a matter of fact, these two methods give the impression that
  // they overlap each other in functionality.
  //
  // However, there's a subtle but very important difference
  // between the two
  // which can affect the performance of our code drastically
  // if not well understood.

  // Let's create a method called getMyDefault() in the test class
  // which takes no arguments and returns a default value:

  public String getMyDefault() {
    System.out.println("Getting Default Value");
    return "Default Value";
  }

  @Test
  public void whenOrElseGetAndOrElseOverlap_thenCorrect() {
    String text = null;

    String defaultText = Optional.ofNullable(text).orElseGet(this::getMyDefault);
    assertEquals("Default Value", defaultText);

    defaultText = Optional.ofNullable(text).orElse(getMyDefault());
    assertEquals("Default Value", defaultText);
  }

  @Test
  public void whenOrElseGetAndOrElseDiffer_thenCorrect() {
    String text = "Text present";

    System.out.println("Using orElseGet:");
    String defaultText
        = Optional.ofNullable(text).orElseGet(this::getMyDefault);
    assertEquals("Text present", defaultText);

    System.out.println("Using orElse:");
    defaultText = Optional.ofNullable(text).orElse(getMyDefault());
    assertEquals("Text present", defaultText);
  }

  // Notice that when using orElseGet() to retrieve the wrapped value,
  // the getMyDefault() method is not even invoked
  // since the contained value is present.
  //
  // However, when using orElse(),
  // whether the wrapped value is present or not,
  // the default object is created.
  // So in this case,
  // we have just created one redundant object that is never used.

  // In this simple example,
  // there is no significant cost to creating a default object,
  // as the JVM knows how to deal with such.
  //
  // However, when a method such as getMyDefault()
  // has to make a web service call or even query a database,
  // then the cost becomes very obvious.
}
