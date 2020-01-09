package com.yao.queue;

import javafx.scene.shape.Circle;

/**
 * 循环队列
 *
 * @author pengjie_yao
 * @date 2020/1/9 15:26
 */
public class CircleQueue {

    private String[] queue;

    /**
     *  队头下标
     */
    private int head;

    /**
     *  队尾下标
     */
    private int tail;

    /**
     *  默认数组容量
     */
    private int DEFAULT_CAPACITY = 10;

    /**
     *  容量
     */
    private int capacity;


    public CircleQueue() {
        this.queue = new String[DEFAULT_CAPACITY];
        this.head = 0;
        this.tail = 0;
        this.capacity = DEFAULT_CAPACITY;
    }

    public CircleQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new String[capacity];
        this.head = 0;
        this.tail = 0;
    }

    /**
     * 入队
     *
     * @param value
     * @return
     */
    public boolean offer(String value) {
        if (((tail + 1) % capacity) == head) {
            return false;
        }
        queue[tail] = value;
        tail = (tail + 1) % capacity;
        return true;

    }

    /**
     * 出队
     *
     * @return
     */
    public String remove() {

        // 队列为空的情况
        if (head == tail) {
            return null;
        }
        String temp = queue[head];
        head = (head + 1) % capacity;
        return temp;

    }

    /**
     *  遍历队列
     */
    public void printAll() {
        int temp = head;
        while (temp != tail) {
            System.out.print(queue[temp]+",");
            temp = (temp + 1) % capacity;
        }
        System.out.println();

    }

    public static void main(String[] args) {
        CircleQueue circleQueue = new CircleQueue(5);
        circleQueue.offer("a");
        circleQueue.offer("b");
        circleQueue.offer("c");
        circleQueue.offer("d");
        circleQueue.printAll();
        circleQueue.remove();
        circleQueue.remove();
        circleQueue.printAll();

    }

}
