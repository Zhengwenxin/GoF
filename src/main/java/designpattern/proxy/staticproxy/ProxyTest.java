package designpattern.proxy.staticproxy;

/**
 * 代理模式 测试代码
 * 说明：
 *
 * 代理模式的优缺点：
 * 优点：
 * 1.代理模式能将代理对象与真实被调用对象分离。
 * 2.在一定程度上降低了耦合性，增强了扩展性。
 * 3.可以起到保护目标对象的作用。
 * 4.可以增强目标对象的功能。
 *
 * 缺点：
 * 1.代理模式会造成系统设计中类的数量增加。
 * 2.在客户端和目标对象中间加一个代理对象会导致请求处理速度变慢。
 * 3.增加了系统的复杂度。
 *
 */
public class ProxyTest {
    public static void main(String[] args) {
        //这里只能传入儿子对象，别的人爸爸不给找，爸爸代理执行儿子的findLove方法。
        Father father = new Father(new Son());
        //儿子没有时间，爸爸帮儿子代理找对象。
        father.findLove();
    }
}
