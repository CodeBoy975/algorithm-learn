package com.yao.recursion;

/**
 *  编程实现求阶乘 n!
 * @author pengjie_yao
 * @date 2020/1/10 9:57
 */
public class Demo2 {

    /**
     *  递归求解步骤
     *          1.递归公式： 2! = 1*2  3! = 1*2*3 = 3*2!
     *                      f(n) = n * f(n-1)
     *          2.结束条件
     *                      n=1,返回1
     * @param n
     * @return
     */
    public static int f(int n) {
        if (n == 1) {
            return n;
        }
        return n * f(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(f(4));
    }
}
