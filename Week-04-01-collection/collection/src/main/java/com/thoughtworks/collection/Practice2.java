package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Practice2 {

  public static void main(String[] args) {
    List<Integer> list = getNumbers();

    //分别用for循环、增强for循环、迭代器遍历并打印getNumbers返回的List

    // for 循环
    System.out.println("======= for loop =======");
    for (int i = 0; i < list.size(); i++) {
      System.out.printf("%d ", list.get(i));
    }
    System.out.println();

    // 增强 for 循环
    System.out.println("======= enhanced 'for' =======");
    for (int number : list) {
      System.out.printf("%d ", number);
    }
    System.out.println();

    //迭代器
    System.out.println("======= iterator =======");
    Iterator<Integer> iterator = list.iterator();
    while (iterator.hasNext()) {
      System.out.printf("%d ", iterator.next());
    }
    System.out.println();
  }

  /**
   * 创建一个List 然后在List中添加0到100整数
   */
  public static List<Integer> getNumbers() {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i <= 100; i++) {
      list.add(i);
    }
    return list;
  }


}
