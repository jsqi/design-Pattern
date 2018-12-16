package com.mars.myjdk;

import java.lang.reflect.Method;

/**
 * @Author mars
 * @Email 13673180154@163.com
 * @Date 2018/12/16
 */
public interface MyInvocationHandler {

    Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
