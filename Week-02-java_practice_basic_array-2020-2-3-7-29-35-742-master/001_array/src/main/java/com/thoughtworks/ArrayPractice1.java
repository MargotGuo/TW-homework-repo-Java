package com.thoughtworks;

import java.util.Arrays;

public class ArrayPractice1 {

    public static void main(String[] args) {
        printArrayReverse();
    }

    /**
     * 倒序打印给定数组,打印格式为: [3,2,1]
     */
    public static void printArrayReverse() {
        int[] array = new int[]{1, 2, 3};
        int len = array.length;
        int[] outputArray = new int[len];
        for(int i = 0; i < len; i++) {
            outputArray[len - i - 1] = array[i];
        }
        System.out.println(Arrays.toString(outputArray));
    }
}
