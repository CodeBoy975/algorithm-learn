package com.yao.recursion;

/**
 * 编程实现斐波那契数列求值 f(n)=f(n-1)+f(n-2)
 * @author pengjie_yao
 * @date 2020/1/10 9:49
 */
public class Demo1 {

    /**
     *  递归实现
     *   步骤：
     *          1.递归的表达式：f(n) = f(n-1)+f(n-2)
     *          2.递归结束条件：
     * @param n
     * @return
     */
    public static int f(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return f(n - 1) + f(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(f(10));
    }
    }
