package com.yao.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 桶排序
 *
 * @author pengjie_yao
 * @date 2020/1/15 11:16
 */
public class BucketSore {


    public static void main(String[] args) {
        int[] array = new int[]{4, 7, 6, 5, 3, 2, 8, 1};
        array = bucketSore(array);
        System.out.print(Arrays.toString(array));
    }

    /**
     * 桶排序
     * 思路：
     *      1.桶的初始化：构建一个集合，集合中的每个元素就是每个桶
     *      2.遍历数组元素，依次放入桶中
     *      3.对桶中的每个元素进行排序
     *      4.输出全部元素
     * @param array
     */
    public static int[] bucketSore(int[] array) {

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
        int d = max - min;

        // 初始化桶
        int bucketNum = array.length;
        ArrayList<LinkedList<Integer>> bucketList = new ArrayList<LinkedList<Integer>>();
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<Integer>());
        }

        // 遍历原始数组，将每个元素放入桶中
        for (int i = 0; i < array.length; i++) {
            int num = (int) ((array[i] - min) * (bucketNum - 1) / d);
            bucketList.get(num).add(array[i]);
        }

        // 对每个桶进行排序
        for (int i = 0; i < bucketList.size(); i++) {
            Collections.sort(bucketList.get(i));
        }

        // 输出全部元素
        int[] sortedArray = new int[array.length];
        int index = 0;
        for (LinkedList<Integer> list : bucketList) {
            for (int element : list) {
                sortedArray[index] = element;
                index++;
            }
        }

        return  sortedArray;
    }
}
