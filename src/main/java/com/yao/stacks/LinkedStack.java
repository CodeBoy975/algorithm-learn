package com.yao.stacks;

/**
 *  链表实现顺序栈
 * @author pengjie_yao
 * @date 2020/1/8 14:20
 */
public class LinkedStack<T> {

    /**
     *  头结点
     */
    private Node head = null;
    /**
     *  指向尾节点
     */
    private Node top;

    public  LinkedStack() {
        this.head = new Node();
    }

    /**
     * 入栈
     * @param val
     * @return
     */
    public boolean push (T val) {
        Node newNode = new Node(val, null);
        newNode.setNext(head.getNext());
        head.setNext(newNode);
        return true;
    }

    /**
     *  出栈
     * @return
     */
    public Node pop () {
        if (head.getNext() == null) {
            return null;
        }
        Node deleteNode = head.getNext();
        head.setNext(deleteNode.getNext());
        return deleteNode;
    }

    /**
     *  遍历链表
     */
    public void printAll() {
        Node temp = head.getNext();
        while (temp != null) {
            System.out.print(temp.getVal()+"->");
            temp = temp.getNext();
        }
        System.out.println();
    }


    public static void main(String[] args) {
        LinkedStack<Integer> stack = new LinkedStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.printAll();
        stack.pop();
        stack.printAll();

    }




    /**
     * 节点
     * @param <T>
     */
    public class Node<T>  {
        private T val;
        private Node next;

        public Node (T val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node() {
            this.next = null;
        }

        public T getVal() {
            return val;
        }

        public void setVal(T val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
