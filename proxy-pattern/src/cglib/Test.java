package com.mars.proxy.jdk.com.mars.proxy.cglib;

/**
 * @Author mars
 * @Email 13673180154@163.com
 * 2018/12/14
 */
public class Test {

    public static void main(String[] args) {
       Star star = (Star) new Agent().getInstance(Star.class);
       star.starVocalConcert();
    }
}
