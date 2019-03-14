package com.summer.geekalgo.linkedlist07;

/**
 * @Package com.summer.geekalgo.linkedlist07
 * @Author: summer
 * @Date: 2019-03-14 23:29
 * 两个有序链表的合并
 */
public class MergeTwoList {


    public static Node merge2List(Node n1, Node n2){
        Node head = null;
        if (null == n1){
            return n2;
        }
        if (null == n2){
            return n1;
        }

        // 如果n1<n2 则最小节点为n1
        if (n1.getData() < n2.getData()){
            head = n1;
            n1 = n1.getNext();
        }else {
            head = n2;
            n2 = n2.getNext();
        }

        Node tmp = head;
        while (n1 != null && n2 != null){
            if (n1.getData() <= n2.getData()){
                tmp.setNext(n1);
                n1 = n1.getNext();
            }else {
                tmp.setNext(n2);
                n2 = n2.getNext();
            }
            tmp = tmp.getNext();
        }
        if (null == n1){
            tmp.setNext(n2);
        }
        if (null == n2){
            tmp.setNext(n1);
        }
        return head;
    }


    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(3);
        Node n3 = new Node(5);
        Node n4 = new Node(7);
        Node n5 = new Node(9);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);

        Node m1 = new Node(2);
        Node m2 = new Node(4);
        Node m3 = new Node(6);
        Node m4 = new Node(8);
        Node m5 = new Node(10);
        m1.setNext(m2);
        m2.setNext(m3);
        m3.setNext(m4);
        m4.setNext(m5);

        Node mergeNode = merge2List(n1, m1);
        Node.printLinkedList(mergeNode);
    }

}
