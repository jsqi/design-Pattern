package com.mars.myjdk;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * @Author mars
 * @Email 13673180154@163.com
 * 2018/12/16
 */
public class Test {

    public static void main(String[] args) {
        MingXing obj = (MingXing) new JingJiRen().getInstance(new BingBing());
        System.out.println(obj.getClass());
        obj.findChangDi();


    }
}
