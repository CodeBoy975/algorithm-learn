package com.yao;

/**
 * 5.最长回文串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * @author pengjie_yao
 * @date 2020/1/18 15:06
 */
public class leetcode {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("a"));
    }

    public static  String longestPalindrome(String s) {
        // 空判断
        if (s == null || s.length() == 0) {
            return "";
        }
        int left = 0;
        int right = 0;
        // 记录回文串的长度
        int length = 1;
        int maxLength = 0;
        int sLeng = s.length();
        int maxStart = 0;

        for (int i = 0; i < s.length(); i++) {

            left = i-1;
            right = i + 1;

            // 左边扩散
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                left--;
                length++;
            }
            // 右边扩展
            while (right < s.length() && s.charAt(right) == s.charAt(i)) {
                right++;
                length++;
            }
            // 获取对应的回文
            while (left >= 0 && right < s.length() && s.charAt(right) == s.charAt(left)) {
                length = length + 2;
                left -- ;
                right++;
            }
            if (length > maxLength) {
                maxLength = length;
                maxStart = left;
            }
            length = 1;
        }
        return s.substring(maxStart + 1, maxStart + maxLength + 1);

    }
}
