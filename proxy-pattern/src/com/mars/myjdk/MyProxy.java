package com.mars.myjdk;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @Author mars
 * @Email 13673180154@163.com
 * @Date 2018/12/16
 */
public class MyProxy {
    private  static final String ln = "\r\n";

    private static String generateSrc(Class<?> interfaces){
        StringBuffer src = new StringBuffer();
        src.append("package com.gupaoedu.vip.custom;" + ln);
        src.append("import java.lang.reflect.Method;" + ln);
        src.append("public class $Proxy0 implements " + interfaces.getName() + "{" + ln);

        src.append("MyInvocationHandler h;" + ln);

        src.append("public $Proxy0(MyInvocationHandler h) {" + ln);
        src.append("this.h = h;" + ln);
        src.append("}" + ln);

        for (Method m : interfaces.getMethods()) {
            src.append("public " + m.getReturnType().getName() + " " + m.getName() + "(){" + ln);

            src.append("try{" + ln);
            src.append("Method m = " + interfaces.getName() + ".class.getMethod(\"" +m.getName()+"\",new Class[]{});" + ln);
            src.append("this.h.invoke(this,m,null);" + ln);
            src.append("}catch(Throwable e){e.printStackTrace();}" + ln);
            src.append("}" + ln);
        }

        src.append("}");

        return src.toString();
    }


    public static Object newProxyInstance(MyClassLoader classLoader,Class<?>[] interfaces,MyInvocationHandler h){
        String proxy = generateSrc(interfaces[0]);

        String filePath = MyProxy.class.getResource("").getPath();
        File file = new File(filePath+"$Proxy0.java");
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(filePath);
            fileWriter.flush();
            fileWriter.close();

            JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = javaCompiler.getStandardFileManager(null,null,null);
            Iterable iterable = manager.getJavaFileObjects(file);
            JavaCompiler.CompilationTask task = javaCompiler.getTask(null,manager,null,null,null,iterable);
            task.call();
            manager.close();

            Class proxyClazz = classLoader.findClass("$Proxy0");
            Constructor constructor =proxyClazz.getConstructor(MyInvocationHandler.class);
            return constructor.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
