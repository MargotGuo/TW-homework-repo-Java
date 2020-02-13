package com.thoughtworks;

public enum Suit {
  SPADE("黑桃"),
  HEART("红桃"),
  CLUB("梅花"),
  DIAMOND("方片");

  private String type;

  Suit(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }
}
