package com.yao.queue;


/**
 *  设计一个循环的双端队列
 *   思考：
 *          什么是循环的双端队列
 *          双端队列： 队头可以出队
 *                    队尾也可以出队
 * @author pengjie_yao
 * @date 2020/1/9 16:24
 */
public class MyCircularDeque {

    private int[] array;

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

    /**
     *  队首
     */
    private int front;

    /**
     *  队尾
     */
    private int rear;

    public MyCircularDeque() {
        capacity = DEFAULT_CAPACITY;
        array = new int[DEFAULT_CAPACITY];
        front = 0;
        rear = 0;
    }

    public MyCircularDeque(int k) {

        capacity = k + 1;
        array = new int[capacity];
        front = 0;
        rear = 0;
    }

    /**
     *  插入值到队头
     * @param value
     * @return
     */
    public boolean insertFront(int value) {

        // 队列已满
        if (isFull()) {
            return false;
        }
        // 队头的前一个元素
        front = (front - 1 + capacity) % capacity;
        array[front] = value;
        return true;
    }

    /**
     *  插入值到队尾
     * @param value
     * @return
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        array[rear] = value;
        rear = (rear + 1) % capacity;
        return true;

    }

    /**
     * 删除队头元素
     * @return
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity;
        return true;

    }

    /**
     *  删除队尾元素
     * @return
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        // rear为0的时候，防止数组越界
        rear = (rear - 1+capacity) % capacity;
        return true;
    }

    /**
     *  获取队头元素
     * @return
     */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return array[front];

    }

    /**
     *  获取队尾元素
     * @return
     */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        // 当rear为0的时候，防止数组越界
        return array[(rear - 1 + capacity) % capacity];

    }

    /**
     *  队列是否为空
     * @return
     */
    public boolean isEmpty() {
        return front == rear;

    }

    /**
     *  队列是否满
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % capacity == front;

    }

    /**
     *  遍历队列
     */
    public void printAll() {
        int temp = front;
        while (temp != rear) {
            System.out.print(array[temp]+",");
            temp = (temp + 1) % capacity;
        }
        System.out.println();

    }

    public static void main(String[] args) {
        MyCircularDeque queue = new MyCircularDeque(5);
        queue.insertFront(1);
        queue.insertFront(2);
        queue.insertFront(3);
        queue.printAll();
        queue.insertLast(4);
        queue.insertLast(5);
        queue.printAll();
        queue.deleteFront();
        queue.deleteFront();
        queue.printAll();

    }
}
/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */