package com.thoughtworks.homework;


import com.thoughtworks.homework.deserializeUtils.BooleanUtil;
import com.thoughtworks.homework.deserializeUtils.ClassFactory;
import com.thoughtworks.homework.deserializeUtils.Deserializable;
import com.thoughtworks.homework.deserializeUtils.IntegerUtil;
import com.thoughtworks.homework.deserializeUtils.StringUtil;
import com.thoughtworks.model.Desk;
import com.thoughtworks.model.JsonModel;
import com.thoughtworks.model.Parrot;
import com.thoughtworks.util.JsonUtil;

import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.asList;

public class App {
  public static void main(String[] args) throws InstantiationException, IllegalAccessException, IOException, NoSuchMethodException, InvocationTargetException {
    String message1 = getMessage1();
//    String message2 = getMessage2();

//    System.out.println(message1);
//    System.out.println(message2);

    Parrot parrot = toObject(message1, Parrot.class);
    System.out.println(parrot);
  }

  public static <T> T toObject(String message, Class<T> clazz) throws IllegalAccessException, InstantiationException {
    T targetObject = clazz.newInstance();
    Field[] declaredFields = clazz.getDeclaredFields();
    Map<String, String> pair = convertMessageToKeyValuePair(message);
    for (Field declaredField : declaredFields) {
      String name = declaredField.getName();
      String value = pair.get(name);

      declaredField.setAccessible(true);
      Class<?> type = declaredField.getType();

      if (type.isPrimitive() || type.equals(String.class)) {
        declaredField.set(targetObject, convertDataType(value, type));
      }
    }
    return targetObject;
  }

  private static <T> T convertDataType (String message, Class<T> clazz) {
    Deserializable<T> deserializeUtil = ClassFactory.getUtil(clazz);
    return deserializeUtil.deserialize(message, clazz);
  }

  private static Map<String, String> convertMessageToKeyValuePair(String message) {
    Map<String, String> map = new HashMap<>();
    message = message.substring(1, message.length() - 1);
    String[] items = message.split(",");
    for (String item : items) {
      String key = trimQuotes(item.split(":")[0]);
      String value = trimQuotes(item.split(":")[1]);
      map.put(key, value);
    }
    return map;
  }

  private static String trimQuotes(String message) {
    if (message.startsWith("\"") && message.endsWith("\"")) {
      return message.substring(1, message.length() - 1);
    }
    return message;
  }

  private static String getMessage1() {
    Parrot parrot = new Parrot();
    parrot.setFlySpeed(100);
    parrot.setCanTalk(true);
    parrot.petName = "wuwu";

    return JsonUtil.toJson(parrot);
  }

  private static String getMessage2() {
    Parrot parrot = new Parrot();
    parrot.setFlySpeed(100);
    parrot.setCanTalk(true);
    parrot.petName = "wuwu";

    final JsonModel jsonModel = new JsonModel("Lily",
        20,
        new Parrot(),
        asList("a", "b"),
        asList(new Parrot(true), parrot),
        asList(new Desk(10), new Desk(20)));

    return JsonUtil.toJson(jsonModel);
  }
}
