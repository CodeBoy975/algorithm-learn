package com.yao.sort;

import java.util.Arrays;

/**
 * 二分查找的变形
 * 1.查找第一个值等于给定值的元素
 * 2.查找最后一个值等于给定值的元素
 * 3.查找第一个大于等于给定值的元素
 * 4.查找最后1个小于等于给定值的元素
 *
 * @author pengjie_yao
 * @date 2020/1/17 10:56
 */
public class BsearchChange {

    /**
     * 初始数组
     */
    private int[] array;
    private final int DEFAULT_CAPACITY = 16;

    public BsearchChange(int[] array) {
        this.array = array;
        this.array = new int[array.length];
    }


    /**
     * 查找第一个值等于给定值的元素
     * 递归方式
     *
     * @param array
     * @param number
     * @return
     */
    public int bsearchOne(int[] array, int number, int lower, int hight) {
        if (lower > hight) {
            return -1;
        }
        int mid = lower + (hight - lower) / 2;
        if (number < array[mid]) {
            return bsearchOne(array, number, lower, mid - 1);
        } else if (number > array[mid]) {
            return bsearchOne(array, number, mid + 1, hight);
        } else {
            if (mid == 0 || array[mid - 1] != number) {
                return mid;
            }
            // 不是第一个值
            return bsearchOne(array, number, lower, mid - 1);
        }
    }

    /**
     * 查找第一个值等于给定值的元素
     * 非递归方式
     *
     * @param array
     * @param number
     * @return
     */
    public int bsearchOne(int[] array, int number) {
        int lower = 0;
        int hight = array.length - 1;
        while (lower <= hight) {
            int mid = lower + (hight - lower) / 2;
            if (number > array[mid]) {
                lower = mid + 1;
            } else if (number < array[mid]) {
                hight = mid - 1;
            } else {
                // 当元素为第一个元素的时候 或者是该元素的前面元素不等于要查找的元素，则表示查找的值为第一个给定值
                if (mid == 0 || array[mid - 1] != number) {
                    return mid;
                } else {
                    hight = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 非递归方式
     * 查找最后一个值为给定的值
     *
     * @param array
     * @param number
     * @return
     */
    public int bsearchTwo(int[] array, int number) {
        int lower = 0;
        int hight = array.length - 1;
        // 这里主要是如何判断查找的该值是最后一个给定的值
        // 最后一个值的后面值不等于该值即可，否则，低的升高
        while (lower <= hight) {
            int mid = lower + (hight - lower) / 2;
            if (number < array[mid]) {
                hight = mid - 1;
            } else if (number > array[mid]) {
                lower = mid + 1;
            } else {
                // 最后一个元素 或者 该元素的下一个元素不等于该元素
                if (mid == (array.length - 1) || array[mid + 1] != number) {
                    return mid;
                }
                lower = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 递归方式
     * 查找最后一个给定值的下标
     *
     * @param array
     * @param number
     * @param lower
     * @param hight
     * @return
     */
    public int bsearchTwo(int[] array, int number, int lower, int hight) {
        if (lower > hight) {
            return -1;
        }
        int mid = lower + (hight - lower) / 2;
        if (number < array[mid]) {
            return bsearchTwo(array, number, lower, mid - 1);
        } else if (number > array[mid]) {
            return bsearchTwo(array, number, mid + 1, hight);
        } else {
            if (mid == (array.length - 1) || array[mid + 1] != number) {
                return mid;
            }
            // 升高访问
            return bsearchTwo(array, number, mid + 1, hight);
        }
    }

    /**
     * 非递归方式
     * 查找第一个大于等于给定值的元素
     *
     * @param array
     * @param number
     * @return
     */
    public int bsearchThree(int[] array, int number) {
        int lower = 0;
        int hight = array.length - 1;
        while (lower <= hight) {
            int mid = lower + (hight - lower) / 2;
            if (array[mid] >= number) {
                // 如果为第一个元素或者 该中间值的上一个元素比要比较的值小，则表示是第一个
                if (mid == 0 || array[mid - 1] < number) {
                    return mid;
                }
                // 不满足上面条件，说明找到的值不是第一个，则缩小方位，高降低
                hight = mid - 1;
            } else {
                lower = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 递归方式
     * 查找第一个大于等于给定值的元素
     *
     * @param array
     * @param number
     * @param lower
     * @param hight
     * @return
     */
    public int bsearchThree(int[] array, int number, int lower, int hight) {
        if (lower > hight) {
            return -1;
        }
        int mid = lower + (hight - lower) / 2;
        if (array[mid] >= number) {
            if (mid == 0 || array[mid - 1] < number) {
                return mid;
            }
            // 查找的范围在中间值的右边
            return bsearchThree(array, number, lower, mid - 1);
        } else {
            return bsearchThree(array, number, mid + 1, hight);
        }
    }

    /**
     * 非递归方式：查找最后一个小于等于给定值的元素
     *
     * @param array
     * @param number
     * @return
     */
    public int bsearchFour(int[] array, int number) {

        int lower = 0;
        int hight = array.length - 1;
        while (lower <= hight) {
            int mid = lower + (hight - lower) / 2;
            if (array[mid] <= number) {
                // 如果中间值等于最后一个   或者  中间值的下一个元素大于给定值，则也表示最后一个
                if (mid == (array.length - 1) || array[mid + 1] > number) {
                    return mid;
                }
                // 不是最后一个元素，则要进行升序
                lower = mid + 1;
            } else {
                hight = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 递归方式：查找最后一个小于等于给定值的元素
     *
     * @param array
     * @param number
     * @param lower
     * @param hight
     * @return
     */
    public int bsearchFour(int[] array, int number, int lower, int hight) {
        if (lower > hight) {
            return -1;
        }
        int mid = lower + (hight - lower) / 2;
        if (array[mid] <= number) {
            // 如果中间值等于最后一个   或者  中间值的下一个元素大于给定值，则也表示最后一个
            if (mid == (array.length - 1) || array[mid + 1] > number) {
                return mid;
            } else {
                // 不是最后一个元素，则要进行升序
                return bsearchFour(array, number, mid + 1, hight);
            }
        } else {
            return bsearchFour(array, number, lower, mid - 1);
        }
    }


    public static void main(String[] args) {
        // 初始化
        int[] array = new int[]{1, 2, 3, 4, 5, 5, 7, 8};
        System.out.println(Arrays.toString(array));
        BsearchChange model = new BsearchChange(array);

        // 查找第一个值等于给定值的元素位置
        System.out.println("非递归方式：查找第一个值等于给定值的元素元素位置为：" + model.bsearchOne(array, 6));
        System.out.println("递归方式：查找第一个值等于给定值的元素位置为：" + model.bsearchOne(array, 6, 0, array.length - 1));
        System.out.println("------------------------------------------------------------------");

        // 查找最后一个值等于给定值的元素位置
        System.out.println("非递归方式：查找最后一个值等于给定值的元素元素位置为：" + model.bsearchTwo(array, 6));
        System.out.println("递归方式：查找最后一个值等于给定值的元素元素位置为：" + model.bsearchTwo(array, 6, 0, array.length - 1));
        System.out.println("------------------------------------------------------------------");

        // 查找第一个大于等于给定值的元素
        System.out.println("非递归：查找第一个大于等于给定值的元素:" + model.bsearchThree(array, 6));
        System.out.println("递归：查找第一个大于等于给定值的元素" + model.bsearchThree(array, 6, 0, array.length - 1));
        System.out.println("------------------------------------------------------------------");

        // 查找最后一个小于等于给定值的元素
        System.out.println("非递归方式：查找最后一个小于等于给定值的元素" + model.bsearchFour(array, 6));
        System.out.println("递归方式：查找最后一个小于等于给定值的元素" + model.bsearchFour(array, 6, 0, array.length - 1
        ));
    }
}
