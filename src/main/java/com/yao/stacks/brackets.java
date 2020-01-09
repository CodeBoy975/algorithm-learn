package com.yao.stacks;

import java.util.*;

/**20. 有效的括号
 * 题目：
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 *                  左括号必须用相同类型的右括号闭合。
 *                  左括号必须以正确的顺序闭合。
 *                  注意空字符串可被认为是有效字符串。
 *

 * @author pengjie_yao
 * @date 2020/1/9 9:16
 */
public class brackets {

    /**
     *
     * 法一：
     * 生成有效的括号
     * 思路：
     *      用1个栈的方式
     *                  1个栈存放压入的括号
     *                  hash的方式，先把三种括号压入，然后根据三种括号去取hash中对应的，如果和栈的栈顶一样，则弹出。
     *
     *  时间复杂度：  循环遍历n次，则最终复杂度为：O(n)
     *  空间复杂度： 用了1个栈进行存储数据，且格外用了hashmap存储，最终的空间复杂度为：O(n)
     * @param s
     * @return
     */
    public static boolean isValid(String s) {

        HashMap<String,String> map = new HashMap();
        map.put(")", "(");
        map.put("]", "[");
        map.put("}", "{");

        char[] chars = s.toCharArray();
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < chars.length; i++) {
            String str1 = map.get(String.valueOf(chars[i]));
            if (str1 != null) {
                if (!stack.isEmpty()) {
                    // 表示是右括号 弹出栈的元素
                    String pop = stack.pop();
                    if (!pop.equals(str1)) {
                        return false;
                    }
                }else {
                    return false;
                }


            }else {
                stack.push(String.valueOf(chars[i]));
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return  false;
    }


    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
}
