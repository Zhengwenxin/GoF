package designpattern.proxy.cglibproxy;

/**
 * CGLib代理的对象不需要实现任何接口，它通过动态继承目标对象实现动态代理
 */
public class Customer {
    public void findLove() {
        System.out.println("肤白貌美大长腿");
    }
}
