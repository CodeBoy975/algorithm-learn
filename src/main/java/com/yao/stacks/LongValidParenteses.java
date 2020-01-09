package com.yao.stacks;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 最长的有效括号
 * 题目：
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * <p>
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * @author pengjie_yao
 * @date 2020/1/9 10:12
 */
public class LongValidParenteses {


    /**
     * 栈顶每次保存的都是上一个“（”的位置即可，我们只要取知之间的最大值作为总数
     * @return
     */
    public static int longestValidParentheses (String s) {

        Stack<Integer> stack = new Stack<Integer>();
        char[] chars = s.toCharArray();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            // 如果是“（” 直接入栈
            if (chars[i] == '(') {
                // 将该所在数组入栈，栈中存的是该元素的小标
                stack.push(i);
            }else {
                // 遍历到的是')'，则弹出栈顶元素
                stack.pop();
                // 这里要看一个如果栈为空，则要把当前数组下标的元素放入栈中。这里主要是为了连续性
                // 栈为空的情况：表示遍历到的）大于入栈的（，所以要记录重新连续的位置
                if (stack.isEmpty()) {
                    stack.push(i);
                }else {
                    // 取遍历到的下标与栈顶元素的差值与当前的最大值进行比较
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()"));
    }

}
