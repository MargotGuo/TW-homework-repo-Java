package com.thoughtworks.homework.deserializeUtils;

public class BooleanUtil implements Deserializable<Boolean> {

  @Override
  public Boolean deserialize(String message, Class<Boolean> Clazz) {
    return Boolean.valueOf(message);
  }
}
