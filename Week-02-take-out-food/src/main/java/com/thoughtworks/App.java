package com.thoughtworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
  private static final String RECEIPT_TITLE = "============= 订餐明细 =============\n";
  private static final String PROMOTION_DECLARATION = "使用优惠:\n";
  private static final String PROMOTIONA = "满30减6元，省6元\n";
  private static final String PROMOTIONB = "指定菜品半价(黄焖鸡，凉皮)，省13元\n";
  private static final String SPLIT_LINE = "-----------------------------------\n";
  private static final String RECEIPT_FOOTER = "===================================";

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("请点餐（菜品Id x 数量，用逗号隔开）：");
    String selectedItems = scan.nextLine();
    String summary = bestCharge(selectedItems);
    System.out.println(summary);
  }

  /**
   * 接收用户选择的菜品和数量，返回计算后的汇总信息
   *
   * @param selectedItems 选择的菜品信息
   */

  public static String bestCharge(String selectedItems) {
    Food[] foodList = saveFoodByArray(selectedItems);
    double sumPriceBeforeDiscount = getSumPriceBeforeDiscount(foodList);
    double discountInPlanA = sumPriceBeforeDiscount >= 30 ? 6 : 0;
    double discountInPlanB = getDiscountInPlaneB(foodList);
    double finalDiscount = Math.max(discountInPlanA, discountInPlanB);
    return String.format("%s%s%s%s%s%s",
        RECEIPT_TITLE,
        getAllFoodInfo(foodList),
        SPLIT_LINE,
        finalDiscount == 0 ? "" : getDiscountInfo(discountInPlanA, discountInPlanB),
        String.format("总计：%s元\n", formatDoubleNumber(sumPriceBeforeDiscount - finalDiscount)),
        RECEIPT_FOOTER);
  }

  public static Food[] saveFoodByArray(String selectedItems) {
    String[] itemArray = selectedItems.split(",");
    List<Food> foodList = new ArrayList<>();
    for (String foodInfo: itemArray) {
      String foodId = foodInfo.split(" x ")[0];
      int foodCount = Integer.parseInt(foodInfo.split(" x ")[1]);
      foodList.add(new Food(foodId, foodCount));
    }
    return foodList.toArray(new Food[0]);
  }

  public static double getSumPriceBeforeDiscount(Food[] foodList) {
    double sumBeforeDiscount = 0;
    for (Food food : foodList) {
      double sumPriceOfThisFood = getItemPrices()[food.getIndex()] * food.getCount();
      sumBeforeDiscount += sumPriceOfThisFood;
    }
    return sumBeforeDiscount;
  }

  public static double getDiscountInPlaneB(Food[] foodList) {
    double discountInPlanB = 0;
    for (Food food : foodList) {
      if (Arrays.asList(getHalfPriceIds()).contains(food.getFoodID())) {
        discountInPlanB += 0.5 * getItemPrices()[food.getIndex()] * food.getCount();
      }
    }
    return discountInPlanB;
  }

  public static String getAllFoodInfo(Food[] foodList) {
    StringBuilder allFoodInfo = new StringBuilder();
    for (Food food : foodList) {
      allFoodInfo.append(String.format("%s x %d = %s元\n", food.getName(), food.getCount(),
          formatDoubleNumber(getItemPrices()[food.getIndex()] * food.getCount())));
    }
    return allFoodInfo.toString();
  }

  public static String getDiscountInfo(double discountInPlanA, double discountInPlanB) {
    return String.format("%s%s%s",
        PROMOTION_DECLARATION, (discountInPlanA >= discountInPlanB ? PROMOTIONA : PROMOTIONB), SPLIT_LINE);
  }

  /**
   * 获取每个菜品依次的编号
   */
  public static String[] getItemIds() {
    return new String[]{"ITEM0001", "ITEM0013", "ITEM0022", "ITEM0030"};
  }

  /**
   * 获取每个菜品依次的名称
   */
  public static String[] getItemNames() {
    return new String[]{"黄焖鸡", "肉夹馍", "凉皮", "冰粉"};
  }

  /**
   * 获取每个菜品依次的价格
   */
  public static double[] getItemPrices() {
    return new double[]{18.00, 6.00, 8.00, 2.00};
  }

  /**
   * 获取半价菜品的编号
   */
  public static String[] getHalfPriceIds() {
    return new String[]{"ITEM0001", "ITEM0022"};
  }

  /* 如果double类型的数字的数值为整数，则转换成整型输出，如果不为整数，则输出原数字 */
  public static String formatDoubleNumber(double inputNumber) {
    if(Math.round(inputNumber) - inputNumber == 0) {
      return String.valueOf((int)inputNumber);
    }
    return String.valueOf(inputNumber);
  }
}
