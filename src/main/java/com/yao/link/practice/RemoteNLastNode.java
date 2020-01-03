package com.yao.link.practice;

/**
 * leetcode 19
 * 题目：给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * @author pengjie_yao
 * @date 2020/1/3 9:49
 */
public class RemoteNLastNode {


    public static void main(String[] args) {

        // 1.构建链表
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);

        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        printLinked(node);

        ListNode listNode = removeNthFromEnd(node, 4);

        printLinked(listNode);
    }

    /**
     * 删除链表的倒数第n个节点
     * 思路：
     *      定义两个指针，让第一个指针先走n步，则到第一个指针走到末尾的时候，则第二个指针，刚好走好要删的前一个节点处
     *      特殊情况考虑：
     *                   如果是最后一个节点/第一个节点的情况是否符合 符合
     *                   如果n大于链表的长度，则删除肯定失败
     *                    如果链表为空，也无法删除
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        // 链表为空，获取要删的节点大于链表的长度
        if (head == null || (n>LinkedLength(head))) {
            return null;
        }
        // 设置带头指针的链表(可以解决临界问题)
        ListNode pre = new ListNode(-1);
        // 定义快慢指针
        ListNode fast  = pre;
        ListNode slow = pre;
        // 快指针先走n步
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        // 快慢指针同时走
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // slow走到要删除的节点的前一个节点
        slow.next = slow.next.next;
        return pre.next;
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
