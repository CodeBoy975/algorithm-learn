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
     * <p>
     * 解题思路：
     * 对于循环数组，则通过比较中间值跟最后值的大小， 从而判断寻找的序列是左序列或者是右序列
     * 例如： 【4，5，6，7，1，2，3】则中间值为7，跟最右边的值3相比，
     * 比如我们查找的是5，则中间值7>5,所以我们应该直接在中间值的右边进行二分查找即可。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int bserch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
                // 中间值比最右边值小
            } else if (nums[mid] < nums[right]) {
                // 中间值小于
                if (nums[mid] < target && nums[right] >= target) {
                    // 缩小范围
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                // 中间值比最右边值小
                if (nums[mid] > target && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 5, 6, 1, 2, 3};
//        System.out.println("查找的位置是：" + bserch(array, 1));
        System.out.println("查找的位置是：" + bserch(array, 1));

    }
    /**
     * 二分查找
     * <p>
     * 解题思路：
     * 对于循环数组，则通过比较中间值跟最后值的大小， 从而判断寻找的序列是左序列或者是右序列
     * 例如： 【4，5，6，7，1，2，3】则中间值为7，跟最右边的值3相比，
     * 比如我们查找的是5，则中间值7>5,所以我们应该直接在中间值的右边进行二分查找即可。
     *
     * @param target
     * @param target
     * @return
     */
    public static int bserch1(int[] array, int target) {

        int lower = 0;
        int hight = array.length - 1;

        while (lower <= hight) {
            int mid = lower + (hight - lower) / 2;
            // 中间值比最右边的值小
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < array[hight]) {
                // 目标值范围在 【中间值，最右边值】
                if (array[mid] < target && array[hight] > target) {
                    lower = mid + 1;
                } else {
                    // 目标值范围不落在【中间值，最右边值】处，则我们要往中间值的左边查找
                    hight = mid - 1;
                }
                // 中间值比最右边值大
            } else if (array[mid] > array[hight]) {
                // 目标值在【左边值，中间值】
                if (array[lower] < target && array[mid] > target) {
                    hight = mid - 1;
                } else {
                    lower = mid + 1;
                }

            }
        }
        return -1;
    }
}
