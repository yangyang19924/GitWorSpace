package com.yangyang.thread;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 两个线程同时运行read方法，你会发现两个线程可以同时或者说是几乎同时运行lock()方法后面的代码，输出的两句话显示的时间几乎一样。这样提高了程序的运行效率。
 * Created by yangyang on 2018/8/21.
 */
public class ReentrantReadWriteLockTest {

    public static void main(String[] args) {
        Service service = new Service();
        MyThread thread1 = new MyThread(service);
        thread1.setName("A");
        thread1.start();

        MyThread thread2 = new MyThread(service);
        thread2.setName("B");
        thread2.start();

    }

    static public class Service {
        private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        public void read() {
            //lock.writeLock().lock();两个线程同时运行read方法，你会发现同一时间只允许一个线程执行lock()方法后面的代码
            lock.readLock().lock();
            try {
                System.out.println("ThreadName = " + Thread.currentThread().getName() + "获得读锁  " + System.currentTimeMillis());
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.readLock().unlock();
            }
        }

        public void write() {
            lock.writeLock().lock();
            try {
                System.out.println("ThreadName = " + Thread.currentThread().getName() + "获得写锁  " + System.currentTimeMillis());
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.writeLock().unlock();
            }
        }
    }

    static public class MyThread extends Thread {
        private Service service;

        public MyThread(Service service) {
            super();
            this.service = service;
        }

        @Override
        public void run() {  //读写互斥
            if("A".equals(Thread.currentThread().getName()))
                service.read();
            else
                service.write();
        }
    }
}

