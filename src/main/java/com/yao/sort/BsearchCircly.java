package com.yao.sort;

/**
 * 二分查找：循环数组
 * 题目描述：如果有序数组是一个循环有序数组，比如 4，5，6，1，2，3。针对这种情况，如何实现一个求“值等于给定值”的二分查找算法呢？
 *
 * @author pengjie_yao
 * @date 2020/1/17 12:17
 */
public class BsearchCircly {

    /**
     * 二分查找
     *
     * @param array
     * @param number
     * @return
     */
    public static int bserch(int[] array, int number) {
        int index = 0;
        for (int i = 0; i < array.length - 2; i++) {
            if (array[i] > array[i + 1]) {
                index = i+1;
                break;
            }
        }
        int lower = array[index];
        int hight = array[(index - 1) % array.length];
        while (array[lower] < array[hight]) {
            int mid = (lower + hight) % array.length;
            if (array[mid] < number) {
                lower = (mid +1) % array.length;
            } else if (array[mid] > number) {
                hight = (mid - 1) % array.length;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 5, 6, 1, 2, 3};
        System.out.println("查找的位置是："+bserch(array, 1));
    }
}
