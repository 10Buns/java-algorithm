package com.summer.geekalgo.linkedlist_06;


import java.util.Scanner;

/**
 * @Version V1.0
 * @Title: LRULinkedList
 * @Package com.summer.geekalgo.linkedlist06
 * @Author: summer
 * @Date: 2019-03-03 23:39
 * @Description: 注意：
 */
public class LRULinkedList<T> {

    // 默认链表容量
    private final static Integer DEFAULT_CAPACITY = 10;
    // 头节点
    private Node<T> headNode;
    // 链表长度
    private int length;
    // 链表容量
    private Integer capacity;

    public LRULinkedList(){
        this.headNode = new Node<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    /**
     * 指定链表容量
     * @param capacity
     */
    public LRULinkedList(int capacity){
        this.headNode = new Node<>();
        this.capacity = capacity;
        this.length = 0;
    }

    /**
     * 添加缓存
     * @param data
     */
    public void add(T data){
        Node preNode = findPreNode(data);
        if (null == preNode){
            if (length >= capacity){//容量超限，删除尾节点
                deleteELementAtEnd(data);
            }
            //插入元素
            insertElemAtHead(data);
        }else {//删除原数据，再插入
            deleteElemOptim(preNode);
            insertElemAtHead(data);
        }
    }

    /**
     * 删除preNode结点下一个元素
     * @param preNode
     */
    private void deleteElemOptim(Node preNode) {
        Node temp = preNode.getNext();
        preNode.setNext(temp.getNext());
//        temp = null;
        length--;
    }

    /**
     * 头节点插入元素
     * @param data
     */
    private void insertElemAtHead(T data){
        Node next = headNode.getNext();
        headNode.setNext(new Node(data, next));
        length++;
    }

    /**
     * 删除尾节点元素
     * @param data
     */
    private void deleteELementAtEnd(T data){
        Node ptr = headNode;
        if (ptr.next == null){
            return;
        }
        //倒数第二个结点
        while (ptr.getNext().getNext() != null){
            ptr = ptr.getNext();
        }
//        Node tmp = ptr.getNext();
        ptr.setNext(null);
//        tmp = null;
        length--;
    }

    /**
     * 获取查找到元素的前一个结点
     * @param data
     * @return
     */
    private Node findPreNode(T data){
        Node node = headNode;
        while (node.next != null){
            if (data.equals(node.getNext().getElement())){
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    private void printAll(){
        Node node = headNode.getNext();
        while (node != null){
            System.out.print(node.getElement() + ",");
            node = node.getNext();
        }
        System.out.println();
    }

    public static class Node<T>{

        private T element;//当前节点
        private Node next;//下一个节点

        public Node(){
            this.next = null;
        }

        public Node(T element){
            this.element = element;
        }

        public Node(T element, Node next){
            this.element = element;
            this.next = next;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }


    }

    public static void main(String[] args) {
        LRULinkedList<Integer> lru = new LRULinkedList<>();
        Scanner sc = new Scanner(System.in);
        while (true){
            lru.add(sc.nextInt());
            lru.printAll();
        }
    }

}
