package com.example;

/**
 * 单例
 */
public class Singleton {
    //私有构造，防止外部实例化
    private Singleton() {
    }

    //volatile 保证多线程环境下可见性，有序性
    private static volatile Singleton singleton;

    public static Singleton getInstance() {
        if (singleton == null) {//避免进入同步代码
            synchronized (Singleton.class) {
                if (singleton == null) {//确保只有一个实例
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
