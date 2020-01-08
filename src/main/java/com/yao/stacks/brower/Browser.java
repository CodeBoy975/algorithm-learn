package com.yao.stacks.brower;

import java.util.LinkedHashSet;

/**
 * 编程实现一个浏览器的前进、后退功能
 *
 * @author pengjie_yao
 * @date 2020/1/8 14:57
 */
public class Browser {

    /**
     * 前进存放的栈
     */
    private LinkedStack forwardStack;

    /**
     * 后退存放的栈
     */
    private LinkedStack backStack;

    /**
     * 当前页
     */
    private String currentPage;

    public Browser() {
        this.forwardStack = new LinkedStack();
        this.backStack = new LinkedStack();
    }

    /**
     * 打开对应的网址
     */
    public void open(String url) {
        if (currentPage != null) {
            this.backStack.push(this.currentPage);
            // 清除前进的栈
            this.forwardStack.clean();
        }
        showUrl(url, "打开");
    }

    /**
     * 展示网址
     *
     * @param url
     * @param pre
     */
    private void showUrl(String url, String pre) {
        this.currentPage = url;
        System.out.println(pre + "网页为：" + url);
    }

    /**
     * 前进
     *
     * @return
     */
    public String goForward() {
        if (this.canGoForward()) {
            this.backStack.push(this.currentPage);
            String forwardUrl = this.forwardStack.pop();
            showUrl(forwardUrl, "前进");
            return forwardUrl;
        }
        System.out.println("无法前进，已经是最新一页");
        return null;
    }

    /**
     * 后退
     */
    public String goBack() {

        if (this.canGoBack()) {
            this.forwardStack.push(this.currentPage);
            String backUrl = this.backStack.pop();
            showUrl(backUrl, "后退");
            return backUrl;
        }
        System.out.println("已经是最后一页，无法后退");
        return null;
    }

    /**
     * 是否可以前進
     *
     * @return
     */
    public boolean canGoForward() {
        return this.forwardStack.getSize() > 0;
    }

    /**
     * 是否可以回退
     *
     * @return
     */
    public boolean canGoBack() {
        return this.backStack.getSize() > 0;
    }

    public class LinkedStack {

        /**
         * 头结点
         */
        private Node head = null;
        /**
         * 指向尾节点
         */
        private Node top;


        private int size;

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public LinkedStack() {
            this.head = new Node();
            this.size = 0;
        }

        /**
         * 入栈
         *
         * @param val
         * @return
         */
        public boolean push(String val) {
            Node newNode = new Node(val, null);
            newNode.setNext(head.getNext());
            head.setNext(newNode);
            size++;
            return true;
        }

        /**
         * 出栈
         *
         * @return
         */
        public String pop() {
            if (head.getNext() == null) {
                return null;
            }
            Node deleteNode = head.getNext();
            head.setNext(deleteNode.getNext());
            size--;
            return deleteNode.getVal();
        }

        public void clean() {
            this.head.setNext(null);
        }

        /**
         * 获取栈顶元素
         *
         * @return
         */
        public Node getTop() {
            if (head.getNext() != null) {
                return head.getNext();
            }
            return null;
        }

        /**
         * 遍历链表
         */
        public void printAll() {
            Node temp = head.getNext();
            while (temp != null) {
                System.out.print(temp.getVal() + "->");
                temp = temp.getNext();
            }
            System.out.println();
        }

        /**
         * 节点
         *
         */
        public class Node {
            private String val;
            private Node next;

            public Node(String val, Node next) {
                this.val = val;
                this.next = next;
            }

            public Node() {
                this.next = null;
            }

            public String getVal() {
                return val;
            }

            public void setVal(String val) {
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

    public static void main(String[] args) {
        Browser brower = new Browser();
        brower.open("www.baidu.com");
        brower.open("www.google.com");
        brower.open("www.sougou.com");
        brower.goBack();
        brower.goForward();
        brower.goForward();
        brower.goBack();
        brower.goBack();
        brower.open("www.yahu.com");
        brower.open("www.taobao.com");
        brower.goBack();
        brower.goBack();
        brower.goBack();
        brower.goBack();

    }
}
