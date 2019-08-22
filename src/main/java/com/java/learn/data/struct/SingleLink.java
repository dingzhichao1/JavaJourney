package com.java.learn.data.struct;

public class SingleLink {

    public static void main(String[] args) {
        Node node = new Node(1).setNext(new Node(2));
        System.out.println(node);


    }





}

/**
 * 定义一个节点
 *
 * (节点中包含元素的值和指向下一个元素的指针)
 * @param <T>
 */
class Node <T>{

    private T t;
    private Node next;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public Node getNext() {
        return next;
    }

    public Node setNext(Node next) {
        this.next = next;
        return this;
    }

    public Node(T t){
        this.t=t;
    }
    public Node(){}

    @Override
    public String toString() {
        return "Node{" +
                "t=" + t +
                ", next=" + next +
                '}';
    }
}
