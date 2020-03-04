package Homework_02_Product;
// 有一个商品类，里面有三个属性：
// 唯一标识Id，商品名称name，以及它的价格price。

public class Product {
  private String id;
  private String name;
  private int price;

  public Product(String id, String name, int price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }
}
