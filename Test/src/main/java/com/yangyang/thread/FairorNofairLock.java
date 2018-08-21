package com.yangyang.thread;


import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yangyang on 2018/8/21.
 */
public class FairorNofairLock {

    public static void main(String[] args) {

        final Service service = new Service(false);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("**线程"+Thread.currentThread().getName()+"运行了");
                service.serviceMethod();
            }
        };

        Thread[] threadArray = new Thread[10];
        for(int i=0;i<10;i++) {
            threadArray[i] = new Thread(runnable);
        }
        for(int i=0;i<10;i++) {
            threadArray[i].start();
        }

    }

    static public class Service{
        private ReentrantLock lock;

        public Service(boolean isFair) {
            super();
            lock = new ReentrantLock(isFair);
        }

        public void serviceMethod() {
            lock.lock();
            try {
                System.out.println("ThreadName = "+Thread.currentThread().getName()+"获得锁定");
            } finally {
                lock.unlock();
            }
        }
    }
}
