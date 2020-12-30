package designpattern.proxy.jdkproxy;

import designpattern.proxy.staticproxy.Person;

/**
 * JDK动态代理 测试代码
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
