/*
package com.java.learn.data.struct;


import java.util.Date;

*/
/**
* @ClassName:     SingleList
* @Description:    单列表
* @Author:         DZC
* @CreateDate:     2019/8/21 17:27
* @Version:        1.0
*//*



public class SingleList {
    public static void main(String[] args) {
        Node node =  new Node().setData("aaaaa").setLink(new Link().setNext(new Node().setData("bbbb").setLink(new Link().setNext(new Node().setLink(null).setData("ccccc")))));
        System.out.println(node.hashCode());
        System.out.println(new Node().setData("aaaaa").hashCode());


    }


}

*/
/**
* @ClassName:     Node
* @Description:    节点
* @Author:         DZC
* @CreateDate:     2019/8/21 18:01
* @Version:        1.0
*//*

class Node <T>{


    private Link link;

    private  Object data;

    public Link getLink() {
        return link;
    }

    public Node setLink(Link link) {
        this.link = link;
        return this;
    }


    public Object getData() {
        return data;
    }

    public Node setData(Object data) {
        this.data = data;
        return this;
    }



    @Override
    public String toString() {
        return "Node{" +
                "link=" + link +
                ", data=" + data +
                '}';
    }
}



class Link{


    private Node next;

    public Node getNext() {
        return next;
    }

    public Link setNext(Node next) {
        this.next = next;
        return this;
    }

    @Override
    public String toString() {
        return "Link{" +
                "next=" + next +
                '}';
    }
}*/
