package com.yao.link.practice;

import java.util.LinkedList;

/**
 * leetcode876
 * 題目：
 *  给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 *
 *   如果有两个中间结点，则返回第二个中间结点。
 *
 *
 * @author pengjie_yao
 * @date 2020/1/3 11:05
 */
public class MiddleNode {

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

        ListNode listNode = middleNode(node);
        printLinked(listNode);
    }


    /**
     *  返回链表的中间节点
     * @param head
     * @return
     */
    public static ListNode middleNode(ListNode head) {

        // 1.控制判断
        if (head == null) {
            return null;
        }
        // 2.定义快慢指针
        ListNode fast = head;
        ListNode slow = head;
        // 3.快指针走2步，慢指针走1步
        while (fast.next != null && fast.next.next!=null ) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 4.获取链表长度
        int length = LinkedLength(head);
        // 5.奇偶判断：偶数则返回慢指针的下一个节点
        if (length % 2 == 0) {
            return slow.next;
        }
        return slow;
    }


    /**
     * 计算链表的长度
     *
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
     *
     * @param head
     */
    private static void printLinked(ListNode head) {
        ListNode node = head;
        while (node != null) {
            if (node.next == null) {
                System.out.print(node.val);
            } else {
                System.out.print(node.val + "->");
            }
            node = node.next;
        }
        System.out.println();
    }


    /**
     * 节点
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
