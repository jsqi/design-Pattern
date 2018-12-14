package com.mars.proxy.jdk;

import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @Author mars
 * @Email 13673180154@163.com
 * 2018/12/14
 */
public class Test {

    public static void main(String[] args) throws Exception {
        Person person = (Person) new Agent().getInstance(new Star());
        System.out.println(person.getClass());
        person.starVocalConcert();


        //获取字节码内容
        byte[] data = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
        FileOutputStream os = new FileOutputStream("/F/$Proxy0.class");
        os.write(data);
        os.close();

    }
}

