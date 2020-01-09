package com.yao.queue;

/**
 * 链表实现队列
 *
 * @author pengjie_yao
 * @date 2020/1/9 15:03
 */
public class LinkedQueue {


    /**
     * 头节点
     */
    private Node head = null;

    /**
     * 尾节点
     */
    private Node tail = null;

    public LinkedQueue() {
        this.head = new Node();
        this.tail = head;
    }

    /**
     * 入队
     *
     * @param value
     */
    public void offer(String value) {
        Node node = new Node(value, null);
        tail.setNext(node);
        tail = node;
    }

    /**
     * 出队
     *
     * @return
     */
    public String remove() {
        // 边界值判断
        if (head.getNext() == null) {
            return null;
        }
        Node temp = head.getNext();
        head.setNext(temp.getNext());
        temp.setNext(null);
        return temp.getValue();
    }


    public void printAll() {
        Node node = head.next;
        while (node != null) {
            if (node.getNext() != null) {
                System.out.print(node.getValue() + "->");
            } else {
                System.out.print(node.getValue());

            }
            node = node.next;
        }
        System.out.println();
    }


    /**
     * 节点定义
     */
    public class Node {


        String value;
        Node next;

        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node() {
            this.next = null;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }

    public static void main(String[] args) {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.offer("A");
        linkedQueue.offer("B");
        linkedQueue.offer("C");
        linkedQueue.offer("D");
        linkedQueue.printAll();
        linkedQueue.remove();
        linkedQueue.remove();
        linkedQueue.printAll();

    }
}
