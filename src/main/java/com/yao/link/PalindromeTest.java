package com.yao.link;

/**
 * 描述： 基于单链表实现的回文算法
 * 参考答案：SinglyLinkedList
 *
 * @author pengjie_yao
 * @date 2020/1/1 16:17
 */
public class PalindromeTest {


    public static void main(String[] args) {
        LinkedNode head = new LinkedNode("a");
        LinkedNode node2 = new LinkedNode("b");
        LinkedNode node3 = new LinkedNode("c");
        LinkedNode node4 = new LinkedNode("d");
        LinkedNode node5 = new LinkedNode("b");
        LinkedNode node6 = new LinkedNode("a");

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        Boolean palindrome = isPalindrome(head);
        System.out.println(palindrome);
    }

    /**
     *  判断该链表是否是回文
     * @param head
     * @return
     */
    public static Boolean isPalindrome(LinkedNode head) {

        // 指针定义
        LinkedNode fast = head;
        LinkedNode slow = head;
        // 存储反转后的链表
        LinkedNode temp = add(null,slow);

        while (fast.next!=null && fast.next.next != null) {
            // 快指针走两步
            fast = fast.next.next;
            // 慢指针走一步
            slow = slow.next;
            // 并且慢指针走的时候，进行反转
            temp = add(temp,slow);
        }
        // 进行链表的比较
        // 如果是奇数
        if (fast.next != null) {
            // 偶数情况，则要多走一步
            slow = slow.next;
        }
        while (slow != null) {
            if (slow.val != temp.val) {
                return false;
            }
            slow = slow.next;
            temp = temp.next;
        }
        return true;
    }

    /**
     *  反转链表
     * @return
     */
    public static LinkedNode add(LinkedNode head,LinkedNode slow){
        if(head == null) {
            LinkedNode newNode = new LinkedNode(slow.val);
            head = newNode;
            return head;
        }
        // 头插法
        LinkedNode newNode = new LinkedNode(slow.val);
        newNode.next = head;
        return newNode;
    }

    /**
     * 节点值
     */
    public static class LinkedNode {

        String val;
        LinkedNode next;

        public LinkedNode(String val) {
            this.val = val;
        }

    }
}
