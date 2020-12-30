package designpattern.proxy.jdkproxy;

import designpattern.proxy.staticproxy.Person;

/**
 * JDK动态代理 测试代码
 * 说明：
 * JDK动态代理采用字节重组，重新生成对象来代替原有对象。
 *
 * JDK动态代理生成对象的步骤如下：
 * 1.获取被代理对象的引用，并获取它的所有接口，反射获取。
 * 2.JDK动态代理重新生成一个新的类，同时新的类要实现被代理类实现的所有接口。
 * 3.动态生成Java代码，新加的业务逻辑方法由一定的逻辑代码调用
 * 4.编译新生成的Java代码.class文件
 * 5.重新加载到JVM中运行
 *
 * 这就叫字节重组，JDK中有一个规范，ClassPath下$开头的.class文件一般都是自动生成的。
 */
public class JdkProxyTest {
    public static void main(String[] args) {
        try {
            Person obj = (Person) new JDKMeipo().getInstance(new Customer());
            obj.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
