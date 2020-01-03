package com.yao.link.practice;

/**
 * leetcode：21
 * 题目：将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author pengjie_yao
 * @date 2020/1/3 10:25
 */
public class MergeTwoList {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node4;

        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(3);
        ListNode node7 = new ListNode(4);

        node5.next = node6;
        node6.next = node7;
        printLinked(node1);
        printLinked(node5);

        ListNode listNode = mergeTwoLists(node1, node5);
        printLinked(listNode);

    }


    /**
     * 合并有序链表
     * 思路：
     *      分别判断两个链表的节点值，那个大，则新的链表则指向它，要定义两个节点：一个保存链表的头节点，方便返回；一个临时节点，用于指向比较后的链表
     *      最后将临时节点指向比较后，链表不为空的剩余链表
     * 特殊情况考虑：
     * 1.如果两个链表有1个链表为空，则直接返回链表不为空的链表
     * 2.两个链表为空，则直接返回空
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // 1.空情况判断
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1 == null && l2 == null) {
            return null;
        }
        // 2.定义合并有序有的链表
        ListNode pre = new ListNode(-1);
        ListNode temp = pre;
        // 3.循环结束的条件：有1个链表长度为空
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                temp.next = l2;
                temp = l2;
                l2 = l2.next;
            } else {
                temp.next = l1;
                temp = l1;
                l1 = l1.next;
            }

        }
        // 4.将新链表的指针指向剩余的链表处
        if (l1 != null) {
            temp.next = l1;
        } else if (l2 != null) {
            temp.next = l2;
        }
        return pre.next;
    }


    /**
     *  递归的解法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        }
        l2.next = mergeTwoLists1(l1, l2.next);
        return l2;
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
