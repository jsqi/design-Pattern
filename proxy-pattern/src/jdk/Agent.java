package com.mars.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author mars
 * @Email 13673180154@163.com
 */
public class Agent implements InvocationHandler {

    private Person target;

    public Object getInstance(Person target){

        this.target = target;
        Class clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    };

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是专业的经纪人" + "找场地给明星开演唱会");
        method.invoke(this.target,args);
        System.out.println("场地合适 就定下来");
        return null;
    }
}
