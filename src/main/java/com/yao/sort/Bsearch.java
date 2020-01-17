package com.yao.sort;

import java.util.Arrays;

/**
 * 二分查找
 *
 * @author pengjie_yao
 * @date 2020/1/17 10:26
 */
public class Bsearch {


    /**
     * 二分查找
     * 前提： 数组必须是有序
     * 返回数组下标
     * 递归方式：
     * 表达式:
     * 取中间值，如果比中间值小，则hight降低
     * 如果比中间值大，则lower升高
     * <p>
     * 结束条件: 如果比这个大，则退出
     *
     * @param array
     */
    public static int bSearch(int[] array, int number, int lower, int hight) {

        // 结束条件
        if (lower > hight) {
            return -1;
        }

        // 取中间值
        int mid = lower + (hight - lower) / 2;
        if (number == array[mid]) {
            return mid;
        }
        // 查找值范围
        if (number < array[mid]) {
            return bSearch(array, number, lower, mid - 1);
        } else {
            return bSearch(array, number, mid + 1, hight);
        }
    }

    /**
     * 非递归方式
     *
     * @param array
     * @param number
     * @return
     */
    public static int bSearch(int[] array, int number) {

        // 边界值属性
        int lower = 0;
        int hight = array.length - 1;

        // 结束条件
        while (lower <= hight) {
            int mid = lower + (hight - lower) / 2;
            // 找到该值，直接返回，否则缩小查找的区域·
            if (number == array[mid]) {
                return mid;
            } else if (number < array[mid]) {
                hight = mid - 1;
            } else {
                lower = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
//        int i = bSearch(array, 2, 0, array.length - 1);
        int i = bSearch(array, 4);
        if (i != -1) {
            System.out.println(array[i]);
        }

        System.out.println(Arrays.toString(array));
    }

}
