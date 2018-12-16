package com.mars.jdk;

import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @Author mars
 * @Email 13673180154@163.com
 * 2018/12/16
 */
public class Test {

    public static void main(String[] args) {
       MingXing mingXing = (MingXing) new JingJiRen().getInstance(new BingBing());
       mingXing.findChangDi();
        byte[] data = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{MingXing.class});
        FileOutputStream os = null;
        try {
            os = new FileOutputStream("/F/project/design-Pattern/proxy-pattern/src/com/mars/jdk/$Proxy0.class");
            os.write(data);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
