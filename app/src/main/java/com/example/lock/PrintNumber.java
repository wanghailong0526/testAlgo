package com.example.lock;

/**
 * @author : wanghailong
 * @date :
 * @description: 线程交替打印奇偶数
 */
public class PrintNumber {
    private static int count = 1;//打印数字
    private static Object object = new Object();//锁对象

    public static void main(String[] args) {
        /***使用 synchronized 一把锁两个线程****/
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    synchronized (object) {
                        if ((count & 1) == 0) {//偶数
                            System.out.println("whl **" + Thread.currentThread().getName() + ": " + count++);
                        }
                    }
                }
            }
        }, "偶数线程").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    synchronized (object) {
                        if ((count & 1) == 1) {//奇数
                            System.out.println("whl **" + Thread.currentThread().getName() + ": " + count++);
                        }
                    }
                }
            }
        }, "奇数线程").start();
        /***使用 synchronized 一把锁两个线程****/

        /***使用 synchronized 配合wait(),notify()一把锁两个线程****/
//        new Thread(new Printer(), "2").start();
//        new Thread(new Printer(), "1").start();
        /***使用 synchronized 配合wait(),notify()一把锁两个线程****/

    }

    private static class Printer implements Runnable {

        @Override
        public void run() {
            while (count <= 100) {
                synchronized (object) {
                    //打印数字并立即释放锁
                    System.out.println("whl **" + Thread.currentThread().getName() + ": " + count++);

                    object.notify();//不会立即释放锁，要等到synchronized代码块执行结束，cpu重新调度最后一个进入wait状态的线程
                    if (count < 100) {
                        try {
                            object.wait();//线程进入等待状态
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }
    }
}
