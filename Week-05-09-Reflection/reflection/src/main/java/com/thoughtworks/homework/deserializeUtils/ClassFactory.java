package com.thoughtworks.homework.deserializeUtils;

import java.util.HashMap;
import java.util.Map;

public class ClassFactory {
  private static final Map<String, Deserializable> pair = new HashMap<>();

  static {
    pair.put("boolean", new BooleanUtil());
    pair.put("Boolean", new BooleanUtil());
    pair.put("int", new IntegerUtil());
    pair.put("Integer", new IntegerUtil());
    pair.put("String", new StringUtil());
  }

  public static <T> Deserializable getUtil (Class<T> clazz) {
    return pair.get(clazz.getSimpleName());
  }
}
