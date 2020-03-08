package com.thoughtworks.homework.deserializeUtils;

public interface Deserializable<T> {
  T deserialize(String message, Class<T> Clazz);
}
