package com.yao.link.practice;

import com.yao.link.LRUBaseLinkedList;

/**
 * 描述： 基于单链表的LRU算法(根据作者的代码复现一遍)
 * <p>
 * LRU算法： 最近最少使用策略
 * 实现方式：用链表实现,并且是带哨兵的头节点(哨兵作为链表的第一个节点，并且值为空)
 *
 * @author pengjie_yao
 * @date 2020/1/5 10:17
 */
public class LRUBaseLinkedListTest<T> {

    /**
     * 默认容量
     */
    private static final Integer DEFAULT_CAPACITY = 10;
    /**
     * 头节点
     */
    private SNode<T> head;

    /**
     * 链表长度
     */
    private Integer length;

    /**
     * 容量
     */
    private Integer capacity;

    /**
     * 默认的构造器
     */
    public LRUBaseLinkedListTest() {
        this.capacity = DEFAULT_CAPACITY;
        this.head = new SNode<T>();
        this.length = 0;
    }

    /**
     * 带参构造器
     *
     * @param capacity
     */
    public LRUBaseLinkedListTest(Integer capacity) {
        this.capacity = capacity;
        this.head = new SNode<T>();
        this.length = 0;
    }

    /**
     * 新增
     * 思路：
     * 1.查找节点是否已存在链表，是的话，则获取该节点的前一个节点(方便删除操作)
     * 2. 进行节点判断：如果原链表存在：删除原链表的节点，插入新的节点到链表中
     * 3.              如果原链表不存在该节点，则判断插入的长度是否已经达到链表的总容量，是的话，则删除链表末尾节点，再插入节点
     *
     * @param data
     * @return
     */
    public void add(T data) {
        SNode preNode = findPreNode(data);
        if (preNode != null) {
            deleteByPreNext(preNode);
            insertBegin(data);
        } else {
            if (length >= this.capacity) {
                deleteEnd();
            }
            insertBegin(data);
        }
    }

    /**
     * 删除链表的尾部节点
     */
    private void deleteEnd() {
        SNode pre = head;
        if (pre.getNext() == null) {
            return;
        }

        while (pre.getNext().getNext() != null) {
            pre = pre.getNext();
        }
        pre.setNext(null);
        length--;
    }


    /**
     * 往链表头部插入新节点
     *
     * @param data
     */
    private void insertBegin(T data) {
        SNode next = head.getNext();
        head.setNext(new SNode(data, next));
        length++;
    }

    /**
     * 删除该节点的下一个节点
     *
     * @param preNode
     */
    private void deleteByPreNext(SNode preNode) {
        if (preNode == null) {
            return;
        }
        if (preNode.getNext() != null && preNode.getNext().getNext() != null) {
            preNode.setNext(preNode.getNext().getNext());
        }
        length--;
    }

    /**
     * 查找该节点的前一个节点
     *
     * @param data
     * @return
     */
    private SNode findPreNode(T data) {
        SNode node = head;
        while (node.getNext() != null) {
            if (data.equals(node.getNext().getElement())) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    /**
     *  输入所有链表
     */
    private void printAll(){
        SNode node = head.getNext();
        while (node != null) {
            System.out.print(node.getElement()+",");
            node = node.getNext();
        }
        System.out.println();
    }


    /**
     * 节点
     *
     * @param <T>
     */
    public class SNode<T> {
        private T element;
        private SNode next;

        /**
         * 带参构造器
         *
         * @param element
         * @param next
         */
        public SNode(T element, SNode next) {
            this.element = element;
            this.next = next;
        }

        /**
         * 默认构造器
         */
        public SNode() {
            this.next = null;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public SNode getNext() {
            return next;
        }

        public void setNext(SNode next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LRUBaseLinkedListTest list = new LRUBaseLinkedListTest();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.printAll();
        list.add(2);
        list.printAll();

    }
}
