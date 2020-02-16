package com.thoughtworks;

public enum Suit {
  SPADE("黑桃", 1),
  HEART("红桃",2),
  CLUB("梅花",3),
  DIAMOND("方片",4);

  private String type;

  Suit(String type, int index) {
    this.type = type;
  }

  public String getType() {
    return type;
  }
}
