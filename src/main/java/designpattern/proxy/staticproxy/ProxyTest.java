package designpattern.proxy.staticproxy;

/**
 * 代理模式 测试代码
 * 说明：
 * 儿子没有时间，爸爸帮儿子代理找对象。
 */
public class ProxyTest {
    public static void main(String[] args) {
        //这里只能传入儿子对象，别的人爸爸不给找，爸爸代理执行儿子的findLove方法。
        Father father = new Father(new Son());
        father.findLove();
    }
}
