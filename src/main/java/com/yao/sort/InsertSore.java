package com.yao.sort;

/**
 * 插入排序
 *
 * @author pengjie_yao
 * @date 2020/1/10 12:23
 */
public class InsertSore {

    /**
     * 插入排序
     * <p>
     * 1、将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
     * 2. 内循环遍历有序序列，将插入的值进行有序序列的比较，找到要插入值的位置
     *
     * @param array
     */
    public static void insertSore(int[] array) {

        for (int i = 1; i < array.length; i++) {
            // 要比较的值
            int temp = array[i];

            int j = i - 1;
            // 遍历已经排序好的数组
            for (; j >= 0; j--) {
                // 查找要插入的值的位置
                if (array[j] > temp) {
                    array[j + 1] = array[j];
                }else {
                    break;
                }
            }
            // 之所以是j--,是因为for循环结束之后，最后一步是进行j--，所以原来的位置是j+1才对
            array[j+1] = temp;
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
        insertSore(array);
        printAll(array);
    }


}
