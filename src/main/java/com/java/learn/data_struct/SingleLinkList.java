package com.java.learn.data_struct;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: SingleLinkList
 * @Description: 单链表操作类
 * @Author: DZC
 * @CreateDate: 2019/8/22 15:53
 * @Version: 1.0
 */
public class SingleLinkList {
    /**
     * 链表是数据结构，链表需要三个元素：头节点，尾节点和长度
     * 节点是组成链表的最基本的元素，主要有：当前元素的值和指针（上一个元素和下一个元素）
     *
     * 节点需要有两个元素：自身存储的数据和标明下一个或上一个的元素调的地址值
     * 除了构成元素之外，列表还需要头和尾两个属性，用来进行添加或删除标记，头用来查询，用来表示链表的源头
     * 尾主要用于插入时，找到插入的位置（没有尾进行标记，插入是逆序的）
     */


    /**
     * 链表头
     */
    private Node head = null;


    private static ReentrantLock  lock=new ReentrantLock();

    /**
     * 链表尾
     */
    private Node tail = null;

    /**
     * 链表长度
     */
    private volatile int length = 0;


    private AtomicInteger  size= new AtomicInteger();

    /**
     * 头插法
     * 头插法的优点：能够避免尾部遍历，每次插入不需要遍历元素插入效率高
     * 头插法的缺点：插入元素的顺序与之前相反
     *
     * @param t
     * @param <T>
     */
    public <T> void insertInToHead(T t) {
        if (head == null) {
            head = new Node(t);
            length++;
            size.incrementAndGet();
        } else {
            Node temp = head;
            head = new Node(t).setNext(temp);
            length++;
            size.incrementAndGet();
        }
    }


    /**
     * 通过synchronized锁来实现头部插入
     * @param t
     * @param <T>
     */
    public synchronized <T> void insertInToHeadSync(T t){
        insertInToHead(t);
    }


    public  <T> void  insertInToHeadLock(T t){
        lock.lock();
        try {
            insertInToHead(t);
        }catch (Exception e){
            e.printStackTrace();
            try {
                lock.lockInterruptibly();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }finally {
            lock.unlock();
        }


    }


    /**
     * 尾插法
     * @param t
     * @param <T>
     */
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

    /**
     * 获取列表长度
     * @return
     */
    public int size() {
        return length;
    }


    //遍历链表，通过索引值找到相应的元素
    public Node whileSingleLinkList(int index) {
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
        Node<T> node = whileSingleLinkList(index);
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
     * 重写toString方法，将SingleLinkList以更加直观的形式进行展现
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
//        SingleLinkList SingleLinkList = new SingleLinkList();
//        SingleLinkList.insertInToTail(1);
//        SingleLinkList.insertInToTail(2);
//        SingleLinkList.insertInToTail(3);
//        SingleLinkList.insertInToTail(4);
//        SingleLinkList.remove(2);
//        System.out.println(SingleLinkList);
//        System.out.println(SingleLinkList.size());
        test1();
    }

    /**
     *多线程的情况下头插入是否会造成冲突
     *
     * 经过测试：多线程并发的情况下，头部插入会造成元素的丢失
     *
     *  头部插入
     *  三个线程加锁：百万级插入  最低450+     最高600+
     *  三个线程不加锁：百万级插入   290+      最高347+
     *  500万  ReentranntLock  5763   5819
     *
     *  500万  synchroined     6759  5722    5693  5690
     */
    public static void test1(){
        long start = System.currentTimeMillis();

        SingleLinkList SingleLinkList = new SingleLinkList();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000000; i++) {
                SingleLinkList.insertInToHead(1);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000000; i++) {
                SingleLinkList.insertInToHead(2);
            }
        });

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 5000000; i++) {
                SingleLinkList.insertInToHead(3);
            }
        });

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println(SingleLinkList.size());
        System.out.println(SingleLinkList.size);
    }


}

