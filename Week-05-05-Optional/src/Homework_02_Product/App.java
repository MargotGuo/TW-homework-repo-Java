package Homework_02_Product;
// 有一个商品类，里面有三个属性：
// 唯一标识Id，商品名称name，以及它的价格price。
//
// 现在有一个商品实例，我们需要判断是否是我们需要购买的商品：
// 商品的名称是手机
// 商品的价格不小于1000元，不大于2000元。
// 请写代码实现。

import java.util.Optional;

public class App {
  public static void main(String[] args) {
    Product product1 = new Product("1", "电视", 1500);
    Product product2 = new Product("2", "手机", 3000);
    Product product3 = new Product("3", "手机", 1600);

    boolean result1 = isPhoneInPriceRange(product1);
    boolean result2 = isPhoneInPriceRange(product2);
    boolean result3 = isPhoneInPriceRange(product3);

    System.out.println(result1); // false
    System.out.println(result2); // false
    System.out.println(result3); // true
  }

  private static boolean isPhoneInPriceRange(Product currentProduct) {
    return Optional.ofNullable(currentProduct)
        .filter(product -> product.getName().equals("手机"))
        .filter(product -> product.getPrice() >= 1000 && product.getPrice() <= 2000)
        .isPresent();
  }
}
