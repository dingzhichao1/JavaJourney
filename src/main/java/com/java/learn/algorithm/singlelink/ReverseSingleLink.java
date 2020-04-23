package com.java.learn.algorithm.singlelink;

/**
 * @Auther: DingZhichao
 * @Date: 2020/4/19 21:18
 * @Description:  翻转单链表
 */
public class ReverseSingleLink {
    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        node.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;

        System.out.println(node.next.next.next.next.data);
        Node reverseNode = reverse(node);
        System.out.println(reverseNode.next.next.next.next.data);
    }

    /**
     * 碰到链表的反转，需要定义pre,next，curr等虚节点
     * @param node
     * @return
     */
    public static Node reverse(Node node){
        Node pre=null;
        Node next = null;
        Node curr=node;
        //遍历节点
        while (curr!=null){
            //保存下一个元素
            next=curr.next;
            //原本的下一个元素设置为上一个元素
            curr.next=pre;
            pre=curr;
            if(next==null){
                break;
            }
            curr=next        ;
        }
        return curr;
    }

}


class Node {
    Object data;
    Node next;

    public Node(Object data){
        this.data=data;
    }
    public Node(){

    }


}
