package com.mars.proxy.jdk.com.mars.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author mars
 * @Email 13673180154@163.com
 * 2018/12/14
 *  经纪人
 */
public class Agent implements MethodInterceptor {

    public Object getInstance(Class clazz){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return  enhancer.create();

    }



    @Override
    public Object intercept(Object object, Method method, Object[] objects, MethodProxy proxy) throws Throwable {

        System.out.println("我是专业的经纪人" + "找场地给明星开演唱会");
        proxy.invokeSuper(object, objects);
        System.out.println("场地合适 就定下来");
        return null;
    }
}
