package com;

public class Demo {

  public static void main(String[] args) {
    Cock cock = new Cock();
    Hen hen = new Hen();
    ChildChicken childChicken = new ChildChicken();

    System.out.format("100元可以买%s %d只\n", cock.getType(), (int)(100 / cock.getPrice()));
    System.out.format("100元可以买%s %d只\n", hen.getType(), (int)(100 / hen.getPrice()));
    System.out.format("100元可以买%s %d只\n", childChicken.getType(), (int)(100 / childChicken.getPrice()));
  }

}
