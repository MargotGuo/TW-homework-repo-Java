package com.thoughtworks;

public class ArrayPractice2 {

    /**
     * 把给定数组中的最大值保存到数组中的第1个元素且原第一个数换到最大值的位置
     */
    public static int[] exchange() {
        int[] array = new int[]{10, 8, 1, 7, 0, 20, 16, 19};
        int max = 0;
        int maxIndex = 0;
        for (int i = 0, len = array.length; i < len; i++) {
            if (array[i] > max) {
                max = array[i];
                maxIndex = i;
            }
        }
        int tempValue = array[0];
        array[0] = max;
        array[maxIndex] = tempValue;
        return array;
    }
}
