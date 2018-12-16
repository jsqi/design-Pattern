package com.mars.myjdk;

import java.io.*;

/**
 * @Author mars
 * @Email 13673180154@163.com
 * @Date 2018/12/16
 */
public class MyClassLoader extends ClassLoader {

    private File baseDir;

    public MyClassLoader() {
        String basePath = MyClassLoader.class.getResource("").getPath();
        this.baseDir = new File(basePath);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = MyClassLoader.class.getPackage().getName()+"."+name;
        if(null != baseDir){
            File file = new File(baseDir,name.replace("\\.","/")+".class");
            if(file.exists()){
                FileInputStream inputStream = null;
                ByteArrayOutputStream outputStream = null;
                try {
                    inputStream = new FileInputStream(baseDir);
                    outputStream = new ByteArrayOutputStream();
                    byte[] bytes = new byte[1024];
                    int len;
                    while ((len = inputStream.read(bytes)) != -1) {
                            outputStream.write(bytes,0,len);
                    }
                    return defineClass(className,outputStream.toByteArray(),0,outputStream.size());
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if(null != outputStream){
                        try {
                            outputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if(null != inputStream){
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }
}
