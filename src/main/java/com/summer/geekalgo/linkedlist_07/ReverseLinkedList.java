package com.summer.geekalgo.linkedlist_07;

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
        while (head.getNext() != null){
            next = head.getNext();
            head.setNext(prev);
            prev = head;
            head = next;
        }
        head.setNext(prev);
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
            cur.setNext(new Node(i, null));
            cur = cur.getNext();
        }
        return head;
    }

    public static void main(String[] args) {

        Node head = initLinkedList(10);

        System.out.println("原始链表:");
        Node.printLinkedList(head);
        System.out.println("\n从头反转链表:");
        Node head1 = reverseByHead(head);
        Node.printLinkedList(head1);
        System.out.println("\n从尾反转链表:");
        Node head2 = reverseByLast(head1);
        Node.printLinkedList(head2);
    }

}
