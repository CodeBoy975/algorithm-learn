package com.yao.sort;

import java.util.Arrays;

/**
 * 计数排序
 *
 * @author pengjie_yao
 * @date 2020/1/15 11:22
 */
public class CountSore {

    public static void main(String[] args) {
        int[] array = new int[]{4, 7, 6, 5, 3, 2, 8, 1};
        countSore(array);
        System.out.print(Arrays.toString(array));
    }

    /**
     * 计数排序:不稳定排序
     *
     * @param array
     */
    public static void countSore(int[] array) {
        // 不稳定的排序
        // 找到数组中的最大值
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        // 找到数组中的最小值
        int length = max - min + 1;
        // 构建新数组的长度则是由最大值-最小值获取
        int[] temp = new int[length];

        // 遍历数组，进行数据存放
        for (int i = 0; i < array.length; i++) {
            temp[array[i] - min]++;
        }
        // 基准值
        int base = max - length;
        int index = 0;
        // 最后，遍历临时数组，将存放的数据进行
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i]; j++) {
                array[index] = i + base;
                index++;
            }
        }
    }

    /**
     * TODO 计数排序： 稳定排序方式
     * @param array
     */
    public static void stableCountSore(int[] array) {
        // 找到数组中的最大值
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        // 找到数组中的最小值
        int length = max - min + 1;
        // 构建新数组的长度则是由最大值-最小值获取
        int[] temp = new int[length];
    }
}
