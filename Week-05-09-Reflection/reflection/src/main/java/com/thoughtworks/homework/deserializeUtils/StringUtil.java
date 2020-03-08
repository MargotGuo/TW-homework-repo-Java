package com.thoughtworks.homework.deserializeUtils;

public class StringUtil implements Deserializable<String> {

  @Override
  public String deserialize(String message, Class<String> Clazz) {
    return message;
  }
}
