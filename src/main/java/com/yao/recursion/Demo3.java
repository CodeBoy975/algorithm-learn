package com.yao.recursion;

import java.util.HashMap;

/**
 *  假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * @author pengjie_yao
 * @date 2020/1/10 10:05
 */
public class Demo3 {

    /**
     * 递归解题步骤：
     *          1.递归表达式： 每次只能爬1步或者2步，
     *              n=1，1种
     *              n=2, 1,1, 2,0  2种
     *              n=3, 1,1,1; 1,2; 2,1  3种
     *              n=4, 1,1,1,1
     *                   1,1,2
     *                   1,2,1
     *                   2,1,1
     *                   2,2              5种
     *                f(n) = f(n-1)+f(n-2)
     *          2.结束条件
     *                 f(3) = f(1)+f(2) = 3
     *                 f(1) = 1
     *                 f(2) = 2
*               3.利用hash表存储已经递归过的数据
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(n+1);
        return climbStairsSaveHash(n, map);
    }

    /**
     *
     * 利用hash表实现递归中重复的问题
     * @param n
     * @param map
     * @return
     */
    public static int climbStairsSaveHash(int n, HashMap<Integer,Integer> map) {
        if (n == 1) {
            return n;
        }
        if (n == 2) {
            return n;
        }
        if (map.get(n) == null) {
            map.put(n, climbStairsSaveHash(n - 1,map) + climbStairsSaveHash(n - 2,map));
        }else {
            return map.get(n);
        }
        return climbStairsSaveHash(n - 1,map) + climbStairsSaveHash(n - 2,map);
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(5));
    }
}
