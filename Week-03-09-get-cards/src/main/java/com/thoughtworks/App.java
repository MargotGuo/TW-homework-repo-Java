package com.thoughtworks;

import java.util.List;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    System.out.println("请输入任意整数(1~52)：");

    Scanner sc = new Scanner(System.in);
    int number = sc.nextInt();

    if (number > 52 || number < 1) {
      System.out.println("错误：数字不在规定范围内");
    } else {
      CardMachine cardMachine = new CardMachine();
      List<Card> outputCards = cardMachine.drawCard(number);
      outputCards.forEach(System.out::print);
    }
  }
}
