package com.yao.sort;

import java.util.Arrays;

/**
 *  快排
 *  学习链接：https://shimo.im/docs/Q3sGXBr66kUx49au/
 * @author pengjie_yao
 * @date 2020/1/15 9:23
 */
public class QuickSore {

    public static void main(String[] args) {
        int[] array = new int[]{4, 7, 6, 5, 3, 2, 8, 1};
        quickSore(array, 0, array.length - 1);
        System.out.print(Arrays.toString(array));
    }

    /**
     * 快速排序
     * 递归方式解题步骤：
     *          1.递归表达式
     *              获取基准元素
     *              基准元素之前的进行快排
     *              基准元素之后部分进行快排
     *          2.结束条件
     *              开始指针大于结束指针位置
     * @author pengjie_yao
     */
    public static void quickSore(int[] array,int startPonit,int endPonit) {
        if (startPonit >= endPonit) {
            return ;
        }
        // 获取基本元素
        int base = partition(array, startPonit, endPonit);
        // 基本元素的前半部分排序
        quickSore(array,startPonit,base-1);
        // 基准元素的后半部分排序
        quickSore(array, base + 1, endPonit);

    }

    /**
     *  获取基准元素
     * @param array
     * @param startPonit
     * @param endPonit
     * @return
     */
    private static int partition(int[] array, int startPonit, int endPonit) {
        // 取第一个元素作为基准元素比较值
        int baseValue = array[startPonit];
        int left = startPonit;
        int right = endPonit;
        while (left != right) {
            // 右指针开始于基准元素比较，当发现小于基本元素，则停止
            while (left < right&& array[right] > baseValue) {
                right--;
            }
            // 左指针向右移动进行基准元素比较，当发现大于基准元素，则停止
            while (left < right &&  array[left] <= baseValue) {
                left++;
            }
            // 进行元素交换
            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
        // 最后左右指针相等时，则找到基准元素的位置，则替换
        array[startPonit] = array[left];
        array[left] = baseValue;
        return left;
    }
}
