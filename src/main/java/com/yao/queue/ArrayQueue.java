package com.yao.queue;


/**
 *  数组实现一个顺序队列
 *  队列的原理： 【先进先出】
 * @author pengjie_yao
 * @date 2020/1/9 14:51
 */
public class ArrayQueue {

    private String[] array;

    /**
     *  默认容量
     */
    private int DEFAULT_CAPACITY = 10;

    /**
     * 数组中的有效个数
     */
    private int count;
    /**
     *  数组容量
     */
    private int capacity;

    public ArrayQueue() {
        this.array = new String[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
    }

    public ArrayQueue(int capacity) {
        this.array = new String[capacity];
        this.capacity = capacity;
    }

    /**
     *  入队
     * @param value
     * @return
     */
    public boolean offer(String value){
        if (count == capacity) {
            return false;
        }
        array[count] = value;
        count++;
        return true;
    }

    /**
     * 出队
     * @return
     */
    public String remove(){
        String temp = array[0];
        for (int i = 0; i < count-1; i++) {
            array[i] = array[i + 1];
        }
        count--;
        return temp;
    }

    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.offer("a");
        arrayQueue.offer("b");
        arrayQueue.offer("c");
        arrayQueue.printAll();
        arrayQueue.remove();
        arrayQueue.printAll();
    }
}
