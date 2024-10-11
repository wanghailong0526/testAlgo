package com.example;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author : wanghailong
 * @date :
 * @description: TODO
 */
public class TestActualClassInfo {
    public static void main(String[] args) {

    }

    public static Class<?> getActualCalssInfo(Object obj) {
        Type type = obj.getClass().getGenericSuperclass();
        Type[] types = ((ParameterizedType) type).getActualTypeArguments();
        return (Class<?>) types[0];
    }
}
