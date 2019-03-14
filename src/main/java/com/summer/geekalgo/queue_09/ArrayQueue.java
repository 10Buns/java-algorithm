package com.summer.geekalgo.queue_09;

/**
 * @Package com.summer.geekalgo.queue_09
 * @Author: summer
 * @Date: 2019-03-14 23:53
 * 数组队列
 */
public class ArrayQueue {

    //数组
    private String[] items;
    //数组大小
    private int capacity = 0;
    //队列头下标
    private int head = 0;
    //队列尾下标
    private int tail = 0;

    public ArrayQueue(int capacity){
        this.items = new String[capacity];
        this.capacity = capacity;
    }

    public boolean enqueue(String item){
        if (tail == capacity){
            System.out.println("入队失败, 队列已满");
            return false;
        }
        System.out.println("入队成功, 下标:" + tail);
        items[tail] = item;
        ++tail;
        return true;
    }

    public String dequeue(){
        if (head == tail){
            System.out.println("出队失败, 队列已空");
            return null;
        }
        System.out.println("出队成功, 下标:"+head);
        String item = items[head];
        ++head;
        return item;
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        for (int i = 0; i < 10; i++){
            arrayQueue.enqueue(i+"");
        }

        for (int i = 0; i < 10; i++){
            arrayQueue.dequeue();
        }

    }


}
