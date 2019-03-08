package com.summer.geekalgo.linkedlist06;

/**
 * @Version V1.0
 * @Title: ReverseLinkedList
 * @Package com.summer.geekalgo.linkedlist06
 * @Author: summer
 * @Date: 2019-03-08 17:33
 * @Description: 单链表反转
 * 注意：
 */
public class ReverseLinkedList {

    /***
     * 从尾部交换
     * @param head
     * @return
     */
    public static Node reverseByLast(Node head){
        if (head == null || head.getNext() == null){
            return head;
        }
        Node nextNode = head.getNext();
        head.setNext(null);
        Node reverseHead = reverseByLast(nextNode);
        //递归走到链表的末端，然后再更新每一个node的next 值
        nextNode.setNext(head);
        return reverseHead;
    }

    /**
     * 从头开始交换
     * @param head
     * @return
     */
    public static Node reverseByHead(Node head){
        if (head == null || head.getNext() == null){
            return head;
        }

        Node prev = null;
        Node next = null;
        while (head.next != null){
            next = head.getNext();
            head.next = prev;
            prev = head;
            head = next;
        }
        head.next = prev;
        return head;
    }

    /**
     * 初始化链表
     * @param num
     * @return
     */
    public static Node initLinkedList(int num) {
        Node head = new Node(0, null);
        Node cur = head;
        for(int i=1; i<num;i++){
            cur.next = new Node(i, null);
            cur = cur.next;
        }
        return head;
    }

    /**
     * 打印链表
     * @param head
     */
    public static void printLinkedList(Node head){
        Node node = head;
        while (node != null){
            System.out.print(node.getData() +"->");
            node = node.getNext();
        }
        System.out.print("null");
    }

    public static class Node{

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

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return next;
        }
    }

    public static void main(String[] args) {

        Node head = initLinkedList(10);

        System.out.println("原始链表:");
        printLinkedList(head);
        System.out.println("\n从头反转链表:");
        Node head1 = reverseByHead(head);
        printLinkedList(head1);
        System.out.println("\n从尾反转链表:");
        Node head2 = reverseByLast(head1);
        printLinkedList(head2);
    }

}
