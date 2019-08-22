package com.java.learn.data.struct;

/**
 * @ClassName: SingleLink
 * @Description: 单链表操作类
 * @Author: DZC
 * @CreateDate: 2019/8/22 15:53
 * @Version: 1.0
 */
public class SingleLink {
    /**
     * 链表是由节点和指针所构成的数据结构
     * 节点需要有两个元素：自身存储的数据和标明下一个或上一个的元素调的地址值
     * 除了构成元素之外，列表还需要头和尾两个属性，用来进行添加或删除标记，头用来查询，用来表示链表的源头
     * 尾主要用于插入时，找到插入的位置（没有尾进行标记，插入是逆序的）
     */


    //链表的头
    private Node head = null;

    //链表的尾
    private Node tail = null;


    private int length = 0;

    //头插法
    public <T> void insertInToHead(T t) {
        if (head == null) {
            head = new Node(t);
            length++;
            return;
        } else {
            Node temp = head;
            head = new Node(t).setNext(temp);
            length++;
        }
    }

    //尾插法
    public <T> void insertInToTail(T t) {
        Node node = new Node(t);
        if (head == null) {
            head = node;
            tail = head;
            length++;
            return;
        } else {
            tail.setNext(node);
            tail = node;
            length++;
        }
    }

    //计算长度
    public int size() {
        return length;
    }


    //遍历链表，通过索引值找到相应的元素
    public Node whileSingleLink(int index) {
        Node node = null;
        if (index < 0 || index > length - 1) {
            throw new IndexOutOfBoundsException();
        }
        node = head;
        for (int i = 0; i < length; i++) {
            if (i == index) {
                return node;
            }
            Node next = node.getNext();
            node = next;
        }
        return node;
    }


    //通过index获取元素数据
    public <T> T get(int index) {
        T t = null;
        Node<T> node = whileSingleLink(index);
        if (node != null) {
            t = node.getT();
        }
        return t;
    }

    /**
     * 通过元素的索引，移除元素
     * 移除元素需要对链表进行遍历，并且注意，头和尾，还有长度的变化
     * @param index
     */
    public void remove(int index) {
        Node node = null;
        if (index < 0 || index > length - 1) {
            throw new IndexOutOfBoundsException();
            //如果是一个元素直接换头
        } else if (0 == index) {
            head = head.getNext();
            length--;
            return;
        }else {
            //如果不是头就及进行遍历
            node = head;
            for (int i = 0; i < length; i++) {
                //先得到该索引的上一个元素
                Node next = node.getNext();
                if (i == index - 1) {
                    node.setNext(next.getNext());
                    if(index == length-1){
                        tail=node;
                    }
                    length--;
                    return;
                }
                node = next;
            }
        }

    }

    /**
     * 重写toString方法，将SingleLink以更加直观的形式进行展现
     * @return
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        Node node = head;
        for (int i = 0; i < length; i++) {
            sb.append(node.toString());
            if (node != tail) {
                sb.append(" -> ");
            }
            Node next = node.getNext();
            node = next;
        }
        sb.append("]");
        return sb.toString();
    }



    public static void main(String[] args) {
        SingleLink singleLink = new SingleLink();
        singleLink.insertInToTail(1);
        singleLink.insertInToTail(2);
        singleLink.insertInToTail(3);
        singleLink.insertInToTail(4);
        singleLink.remove(2);
        System.out.println(singleLink);
        System.out.println(singleLink.size());
    }


}

