package com.thoughtworks.homework.deserializeUtils;

public class IntegerUtil implements Deserializable<Integer>{
  @Override
  public Integer deserialize(String message, Class<Integer> Clazz) {
    return Integer.parseInt(message);
  }
}
