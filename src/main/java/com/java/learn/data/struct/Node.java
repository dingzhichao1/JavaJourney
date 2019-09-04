package com.java.learn.data.struct;
/**
 * 定义一个节点
 *
 * (节点中包含元素的值和指向下一个元素的指针)
 * @param <T>
 */
public  class Node <T>{

    private T t;  //Node中的元素

    private Node next; //Node节点

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
        int hasCode = (next == null) ? 0 : next.hashCode();
        return "Node{" +
                "t=" + t +
                ", next=" + hasCode +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /**
     * 判断是否存在下一个元素
     * @return
     */
    public boolean hasNext(){
        if(this.getNext()==null){
            return false;
        }
        return true;

    }
}
