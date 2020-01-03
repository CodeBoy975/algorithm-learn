package com.yao.link.practice;

/**
 * leetcode 141:
 * 题目：
 *  给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 例如：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * @author pengjie_yao
 * @date 2020/1/3 11:25
 */
public class HasCycle {


    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node2;

        System.out.println(hasCycle(node));
    }


    /**
     *  判断链表是否有环
     * @param head
     * @return
     */
    public static  boolean hasCycle(ListNode head) {

        // 1.空判断
        if (head == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;
        // 2.快指针每次走2步，慢指针每次走一步
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
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
