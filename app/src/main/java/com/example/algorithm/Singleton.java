package com.example.algorithm;


public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {//第一次检查，避免不必要的同步
            synchronized (Singleton.class) {//同步块
                if (instance == null) {//第二次检查，确保只有一个实例被创建
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
