package com.summer.geekalgo.linkedlist07;

import java.util.HashMap;

/**
 * @Version V1.0
 * @Title: LoopLinkedList
 * @Package com.summer.geekalgo.linkedlist07
 * @Author: summer
 * @Date: 2019-03-10 13:42
 * @Description: 链表环检测
 * 注意：
 */
public class LoopLinkedList {


    /**
     * 首先创建一个以节点ID为键的HashSet集合，用来存储曾经遍历过的节点。
     * 然后同样是从头节点开始，依次遍历单链表的每一个节点。
     * 每遍历到一个新节点，就用新节点和HashSet集合当中存储的节点作比较，
     * 如果发现HashSet当中存在相同节点ID，则说明链表有环，
     * 如果HashSet当中不存在相同的节点ID，就把这个新节点ID存入HashSet，
     * 之后进入下一节点，继续重复刚才的操作。
     *
     * 假设从链表头节点到入环点的距离是D，链表的环长是S。而每一次HashSet查找元素的时间复杂度是O(1),
     * 所以总体的时间复杂度是1*(D+S)=D+S，可以简单理解为O(N)。而算法的空间复杂度还是D+S-1，可以简单地理解成O(N)。
     * @param head
     * @return
     */
    public static boolean hasLoop1(Node head){
        Node tmp = head;
        HashMap<Node, Node> ns = new HashMap<>();
        while (tmp != null){
            if (ns.get(tmp) != null){
                return true;
            }else {
                ns.put(tmp, tmp);
            }
            tmp = tmp.getNext();
            if (tmp == null){
                return false;
            }
        }
        return true;
    }

    /**
     * 首先创建两个指针1和2（在java里就是两个对象引用），同时指向这个链表的头节点。然后开始一个大循环，
     * 在循环体中，让指针1每次向下移动一个节点，让指针2每次向下移动两个节点，然后比较两个指针指向的节点是否相同。
     * 如果相同，则判断出链表有环，如果不同，则继续下一次循环。
     * @param head
     * @return
     */
    public static boolean hasLoop2(Node head){
        Node slowNode = head;
        Node fastNode = head.getNext();
        while (fastNode != null){
            int slowData = slowNode.getData();
            int fastData = fastNode.getData();
            if (slowData == fastData){//指针相同，存在环
                return true;
            }
            slowNode = slowNode.getNext();
            fastNode = fastNode.getNext().getNext();
            if (fastNode == null){
                return false;
            }

        }
        return true;//说明元素只有一个，也可以说明是存在环
    }


    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n1);  //构造一个带环的链表

        System.out.println(hasLoop2(n1));
    }

}
