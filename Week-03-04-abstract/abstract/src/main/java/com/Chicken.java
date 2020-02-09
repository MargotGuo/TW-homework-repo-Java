package com;

public class Chicken {
  private double price;

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getType() {
    return getClass().getSimpleName();
  }

}
