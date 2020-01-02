package com.yao.link;

/**
 * 描述： 实现LRU缓存
 * <p>
 * 实现思路： 用链表，则每次都遍历链表，如果有该节点，则删除该节点，并且重新将该节点放入到头结点中
 *
 * @author pengjie_yao
 * @date 2020/1/1 15:25
 */
public class LRUTest {


    public static void main(String[] args) {

        // 1.初始化链表
        LinkedNode head = new LinkedNode(-1);
        LinkedNode node1 = new LinkedNode(1);
        LinkedNode node2 = new LinkedNode(2);
        LinkedNode node3 = new LinkedNode(3);
        LinkedNode node4 = new LinkedNode(4);
        LinkedNode node5 = new LinkedNode(5);
        head.next = node1;
        node1.pre = head;
        node1.next = node2;
        node2.pre = node1;
        node2.next = node3;
        node3.pre = node2;
        node3.next = node4;
        node4.pre = node3;
        node4.next = node5;
        node5.pre = node4;
        // 2.加入链表
        add(head, null);
        // 3.遍历链表
        printNode(head);
        // 4.加入重复的链表
        LinkedNode node6 = new LinkedNode(3);
        add(head, node6);
        // 5.遍历链表
        printNode(head);

    }

    public static void printNode(LinkedNode head) {
        LinkedNode linkedNode = head.next;
        while (linkedNode != null) {
            if (linkedNode.next == null) {
                System.out.print(linkedNode.val);
            } else {
                System.out.print(linkedNode.val + "->");
            }
            linkedNode = linkedNode.next;
        }
        System.out.println();
    }

    public static void add(LinkedNode head, LinkedNode node) {
        // 1.如果节点不存在，则直接返回
        if (node == null || head == null) {
            return;
        }
        // 2.遍历头节点，看是否存在，存在则删除
        LinkedNode linkedNode = head.next;
        while (linkedNode != null) {
            if (node.val == linkedNode.val) {
                // 前节点指向下下一个节点
                LinkedNode pre = linkedNode.pre;
                pre.next = linkedNode.next;
                linkedNode.next.pre = pre;
                // 下下一个节点指向前节点
                break;
            }
            linkedNode = linkedNode.next;
        }
        // 3.插入到头结点的头部
        node.next = head.next;
        head.next.pre = node;
        node.pre = head;
        head.next = node;
    }


    /**
     * 节点值
     */
    public static class LinkedNode {

        int val;
        LinkedNode next;
        LinkedNode pre;

        public LinkedNode(int val) {
            this.val = val;
        }

    }
}
