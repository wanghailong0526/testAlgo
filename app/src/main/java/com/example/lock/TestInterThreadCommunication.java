package com.example.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : wanghailong
 * @date :
 * @description: 线程间通信的5种方式
 * 一、使用 volatile 关键字
 * 二、使用 Object 类的 wait（）/notify（）
 * 三、使用JUC工具类 CountDownLatch
 * 四、使用 ReentrantLock 结合 Condition
 * 五、基本 LockSupport 实现线程间的阻塞和唤醒
 */
public class TestInterThreadCommunication {

    /**
     * 定义共享变量来实现通信，它需要volatile修饰，否则线程不能及时感知
     ***/
    static volatile boolean notice = false;

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        //线程A
        Thread threadA = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                list.add("abc");
                System.out.println("线程A添加元素，此时list的size为：" + list.size());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (list.size() == 5)
                    notice = true;
            }
        });
        //线程B
        Thread threadB = new Thread(() -> {
            while (true) {
                if (notice) {
                    System.out.println("线程B收到通知，开始执行自己的业务...");
                    break;
                }
            }
        });
        //需要先启动线程B
        threadB.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 再启动线程A
        threadA.start();
    }
    /**************************************************************************/

    /**使用 Object 类的 wait()/notify()****/
//    public static void main(String[] args) {
//        //定义一个锁对象
//        Object lock = new Object();
//        List<String> list = new ArrayList<>();
//        // 线程A
//        Thread threadA = new Thread(() -> {
//            synchronized (lock) {
//                for (int i = 1; i <= 10; i++) {
//                    list.add("abc");
//                    System.out.println("线程A添加元素，此时list的size为：" + list.size());
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    if (list.size() == 5)
//                        lock.notify();//唤醒B线程
//                }
//            }
//        });
//        //线程B
//        Thread threadB = new Thread(() -> {
//            System.out.println("B线程开始运行！");
//            while (true) {
//                synchronized (lock) {
//                    if (list.size() != 5) {
//                        try {
//                            lock.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    System.out.println("线程B收到通知，开始执行自己的业务...");
//                }
//            }
//        });
//        //需要先启动线程B
//        threadB.start();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        //再启动线程A
//        threadA.start();
//    }

    /**************************************************************************/

    /****使用JUC工具类 CountDownLatch*/
//    public static void main(String[] args) {
//        CountDownLatch countDownLatch = new CountDownLatch(1);
//        List<String> list = new ArrayList<>();
//        //线程A
//        Thread threadA = new Thread(() -> {
//            for (int i = 1; i <= 10; i++) {
//                list.add("abc");
//                System.out.println("线程A添加元素，此时list的size为：" + list.size());
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                if (list.size() == 5)
//                    countDownLatch.countDown();
//            }
//        });
//        //线程B
//        Thread threadB = new Thread(() -> {
//            while (true) {
//                if (list.size() != 5) {
//                    try {
//                        countDownLatch.await();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                System.out.println("线程B收到通知，开始执行自己的业务...");
//                break;
//            }
//        });
//        //需要先启动线程B
//        threadB.start();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        //再启动线程A
//        threadA.start();
//    }

    /**************************************************************************/

    /***使用 ReentrantLock 结合 Condition*/
//    public static void main(String[] args) {
//        ReentrantLock lock = new ReentrantLock();
//        Condition condition = lock.newCondition();
//
//        List<String> list = new ArrayList<>();
//        //线程A
//        Thread threadA = new Thread(() -> {
//            lock.lock();
//            for (int i = 1; i <= 10; i++) {
//                list.add("abc");
//                System.out.println("线程A添加元素，此时list的size为：" + list.size());
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                if (list.size() == 5)
//                    condition.signal();
//            }
//            lock.unlock();
//        });
//        //线程B
//        Thread threadB = new Thread(() -> {
//            lock.lock();
//            if (list.size() != 5) {
//                try {
//                    condition.await();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            System.out.println("线程B收到通知，开始执行自己的业务...");
//            lock.unlock();
//        });
//        threadB.start();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        threadA.start();
//    }
    /**************************************************************************/


    /***基于 LockSupport 实现线程间的阻塞和唤醒*/
//    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        //线程B
//        final Thread threadB = new Thread(() -> {
//            if (list.size() != 5) {
//                LockSupport.park();
//            }
//            System.out.println("线程B收到通知，开始执行自己的业务...");
//        });
//        //线程A
//        Thread threadA = new Thread(() -> {
//            for (int i = 1; i <= 10; i++) {
//                list.add("abc");
//                System.out.println("线程A添加元素，此时list的size为：" + list.size());
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                if (list.size() == 5)
//                    LockSupport.unpark(threadB);
//            }
//        });
//        threadA.start();
//        threadB.start();
//    }

    /**************************************************************************/


}

