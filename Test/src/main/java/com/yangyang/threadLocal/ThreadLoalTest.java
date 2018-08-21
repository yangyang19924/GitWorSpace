package com.yangyang.threadLocal;

/**
 * Created by yangyang on 2018/8/21.
 */
public class ThreadLoalTest {

    public static void main(String[] args) {
        Thread ta = new Thread(new Thread1(),"A");
        Thread tb = new Thread(new Thread1(),"B");
        Thread tc = new Thread(new Thread1(),"C");

        ta.start();
        tb.start();
        tc.start();

    }

    static public class Thread1 implements Runnable {
        @Override
        public void run() {
            // 线程的id是在它第一次run的时候才分配的，它run，它请求分配id，系统给它一个id
            int id = UniqueThreadIdGenerator.getCurrentThreadId();
            System.out.println(Thread.currentThread().getName()+" is running, its ID is "+id);

            // 三次向系统请求数据
            for(int i=0;i<3;i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName()+" is asking for data, my ID is:"+id);
            }

            System.out.println(Thread.currentThread().getName()+" is over!--------");
        }
    }
}
