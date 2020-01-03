package com.yao.link.practice;

/**
 * leetcode 206： 反转链表
 * 题目：
 *  反转一个单链表。
 *
 * 示例:
 *
 *      输入: 1->2->3->4->5->NULL
 *      输出: 5->4->3->2->1->NULL
 *      个人文章学习：https://blog.csdn.net/weixin_38426554/article/details/96174728
 *
 * @author pengjie_yao
 * @date 2020/1/3 14:46
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        printLinked(node);
        ListNode listNode = reverseList(node);
        printLinked(listNode);

    }

    /**
     * 反转链表
     * 解题思路：
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {

        // 1.空值判断
        if (head == null) {
            return null;
        }

        // 定义1个用来
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            // 暂存下一个节点
            ListNode next = current.next;
            // 节点指向前一个节点
            current.next = pre;
            // 让前节点成为当前节点
            pre = current;
            // 当前节点变为下一个节点
            current = next;
        }

        return pre;
    }


    /**
     * 计算链表的长度
     * @param head
     * @return
     */
    private static int LinkedLength(ListNode head) {
        ListNode node = head;
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    /**
     * 遍历链表
     * @param head
     */
    private static void printLinked(ListNode head) {
        ListNode node = head;
        while (node != null) {
            if (node.next == null) {
                System.out.print(node.val);
            }else {
                System.out.print(node.val+"->");
            }
            node = node.next;
        }
        System.out.println();
    }


    /**
     *  节点
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
