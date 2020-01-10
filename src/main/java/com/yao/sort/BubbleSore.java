package com.yao.sort;

/**
 *  冒泡排序
 * @author pengjie_yao
 * @date 2020/1/10 12:02
 */
public class BubbleSore {

    /**
     *  冒泡排序
     *   内部： 两两比较之后进行交换，最终最大值会出现在最后
     *   边界值判断就是：
     *              j+1,这里的结束条件是什么，每次比较完，则不需要比较最后的元素，因为最后的元素已经是有序的了。
     * @param array
     */
    public static void baseBubbleSore(int[] array) {

        // 遍历1次，则第一个元素跟后面的每个元素进行比较
        for (int i = 0; i < array.length; i++) {
            // 若一轮比较下来没有元素交换，则表示已经有序
            Boolean isSore = true;
            for (int j = 0; j < array.length-i-1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    isSore = false;
                }

            }
            if (isSore) {
                break;

            }
        }
    }

    public static void printAll(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+",");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] array = new int[]{110, 9, 8, 7, 6, 5, 4};
        baseBubbleSore(array);
        printAll(array);
    }
}
