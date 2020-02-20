package com.thoughtworks;

import java.util.List;

public class RepositoryUtil {

  private RepositoryUtil() {
  }

  public static <E> void printList(List<E> entityList) {
    for (E entity : entityList) {
      System.out.println(entity);
    }
  }
}
