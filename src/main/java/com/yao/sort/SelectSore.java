package com.yao.sort;

/**
 * 选择排序
 * @author pengjie_yao
 * @date 2020/1/10 15:11
 */
public class SelectSore {

    /**
     * 选择排序
     *  步骤：
     *      1.外尺遍历，都能确定1个值
     *      2. 内层循环，则能找到第i小的值的索引
     *      3.将第i小标的值与找到dii小的值进行替换
     * @param array
     */
    public static void selectSore(int[] array) {
        for (int i = 0; i < array.length; i++) {
            // 找到最小值的下标
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    public static void printAll(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 3, 2, 1};
        selectSore(array);
        printAll(array);
    }
}
