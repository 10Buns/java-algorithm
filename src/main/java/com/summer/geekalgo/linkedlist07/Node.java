package com.summer.geekalgo.linkedlist07;

/**
 * @Version V1.0
 * @Title: Node
 * @Package com.summer.geekalgo.linkedlist07
 * @Author: summer
 * @Date: 2019-03-10 13:45
 * @Description: 注意：
 */
public class Node {
    private int data;
    private Node next;

    public Node(){
        this.next = null;
    }

    public Node(int data){
        this.data = data;
    }

    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
