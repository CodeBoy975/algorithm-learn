package com.yao.sort;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author pengjie_yao
 * @date 2020/1/15 10:02
 */
public class MergeSore {

    public static void main(String[] args) {
        int[] array = new int[]{4, 7, 6, 5, 3, 2, 8, 1};
        Sore(array);
        System.out.print(Arrays.toString(array));
    }

    /**
     * 归并排序
     * 思路：
     *
     * @param array
     */
    public static void Sore(int[] array) {
        int[] temp = new int[array.length];

        mergeSore(array, 0, array.length - 1, temp);
    }

    /**
     * 归并排序
     * 递归解法：
     * 解题步骤：
     * 递归表达式
     * 选取中间点，两边分别进行归并排序
     * 结束条件
     * 左指针小于右指针则退出
     *
     * @param array
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSore(int[] array, int left, int right, int[] temp) {

        if (left < right) {
            int mid = (left + right) / 2;
            mergeSore(array, left, mid, temp);
            mergeSore(array, mid + 1, right, temp);
            merge(array, left, mid, right, temp);
        }
    }

    /**
     * 将两个有序数据进行排序
     *
     * @param array
     * @param left
     * @param mid
     * @param right
     * @param temp
     */
    private static void merge(int[] array, int left, int mid, int right, int[] temp) {
        // 使用两个指针，分别指向两个数组，数组1 array[0,mid]，数组2 array[mid+1.right]
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            // 左序列的值小于右边，则将该值加入到临时数组中，并且左边序列+1
            if (array[i] <= array[j]) {
                temp[t] = array[i];
                t++;
                i++;
            } else {
                // 右序列的值小于左边，则将该值加入到临时数组中，并且右边序列+1
                temp[t] = array[j];
                t++;
                j++;
            }
        }
        // 两个序列中还有1个序列留有数据的情况，左边序列未满，则将数据直接放入到临时数组后面
        while (i <= mid) {
            temp[t] = array[i];
            t++;
            i++;
        }
        // 两个序列中还有1个序列留有数据的情况，右边序列未满，则将数据直接放入到临时数组后面
        while (j <= right) {
            temp[t] = array[j];
            t++;
            j++;
        }
        // 将temp数组数据更新到array中
        t = 0;
        while (left <= right) {
            array[left++] = temp[t++];
        }
    }
}
