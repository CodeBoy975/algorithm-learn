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
        int[] array = new int[]{94, 97, 96, 95,93,92, 98, 91};
//        countSore(array);
        array = stableCountSore(array);
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
     *
     * @param array
     */
    public static int[] stableCountSore(int[] array) {
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

        for (int i = 0; i < array.length; i++) {
            temp[array[i] - min]++;
        }

        // 统计数组做变形，后面的元素等于前面的元素之和
        for (int i = 1; i < temp.length; i++) {
            temp[i] = temp[i - 1] + temp[i];
        }

        // 倒序遍历原始数列，从统计数组找到正确位置，输出到结果数组,这是重点
        int[] soretedArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            // 此刻的temp数组
            int a = temp[array[i] - min];
            // a-1是因为数组下标是从0开始的
            int idex = a - 1;
            soretedArray[temp[array[i] - min] - 1] = array[i];
            temp[array[i] - min]--;
        }
        return soretedArray;
    }
}
