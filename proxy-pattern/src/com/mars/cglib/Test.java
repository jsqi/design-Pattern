package com.mars.cglib;

/**
 * @Author mars
 * @Email 13673180154@163.com
 * @Date 2018/12/16
 */
public class Test {

    public static void main(String[] args) {
        MingXing mingXing = (MingXing) new JingJiRen().getInstance(MingXing.class);
        mingXing.findChangDi();


    }
}
