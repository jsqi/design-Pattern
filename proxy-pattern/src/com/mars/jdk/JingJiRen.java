package com.mars.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author mars
 * @Email 13673180154@163.com
 * @Date 2018/12/16
 */
public class JingJiRen implements InvocationHandler {

    private Object target;

    public Object getInstance(Object target){
        this.target = target;
        Class clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this::invoke);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是冰冰的经纪人 要找的场地：");
        method.invoke(this.target,args);
        return null;
    }
}
