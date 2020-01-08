package com.yao.stacks;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 用数组实现一个顺序栈
 *
 * @author pengjie_yao
 * @date 2020/1/8 12:03
 */
public class ArrayStack {

    /**
     * 数组
     */
    private String[] stack;

    /**
     * 默认数据长度
     */
    private final int DEFAULT_CAPACITY = 10;

    /**
     * 容量
     */
    private int capacity;

    /**
     *  元素个数
     */
    private int count;

    /**
     * 默认构造器
     *
     * @param capacity
     */
    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.stack = new String[capacity];
    }

    /**
     * 带参构造器
     */
    public ArrayStack() {
        this.capacity = DEFAULT_CAPACITY;
        this.stack = new String[DEFAULT_CAPACITY];
    }
    // 方法 压栈  出栈

    /**
     * 压栈
     */
    public Boolean push(String val) {
        // 如果数据长度==容量，则失败
        if (count == capacity) {
            return false;
        }
        // 数组长度+1，并放入数组
        stack[count] = val;
        count++;
        return true;
    }


    /**
     * 出栈
     * @return
     */
    public String pop() {
        // 数组长度为0，则表示没有元素，返回null
        if (count == 0) {
            return null;
        }
        String popValue = stack[count - 1];
        --count;
        return popValue;
    }


    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack();
        arrayStack.push("a");
        arrayStack.push("b");
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        arrayStack.push("c");
        arrayStack.push("d");
        arrayStack.push("e");
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());

    }
}
