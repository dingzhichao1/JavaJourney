package com.java.learn.jdk.concurrent;


/**
 * @Auther: DingZhichao
 * @Date: 2019/11/19 15:24
 * @Description:
 */
public class VolatileTest {
    boolean stop = false;
//	volatile boolean stop = false;

    public static void main(String[] args) throws Exception{
        TaskDemo task = new TaskDemo();
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.setName("A");
        t2.setName("B");
        t1.start();
        t2.start();
    }

    public void execute(){
        while(!stop){
            String a = "a";
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("大大泡泡糖");
        }
        //System.out.println("解放了");
    }
    public void shutdown(){
        System.out.println("do stop");
        stop = true;
    }


}

class TaskDemo implements Runnable{


    Service service=new Service();
    //private AtomicInteger state=new AtomicInteger(0);

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        String name = thread.getName();
        if("A".equals(name)){

            service.serviceA();
        }else if("B".equals(name)){
            service.serviceB();
        }
    }
}

class  Service{
    private  volatile int state=0;

    public void serviceA(){
        System.out.println("A已经修改");
        state=1;

    }
    public void serviceB(){
        while(state==0){
            System.out.println("改状态。。。");
        }
        System.out.println("B已经接受状态");

    }


}
