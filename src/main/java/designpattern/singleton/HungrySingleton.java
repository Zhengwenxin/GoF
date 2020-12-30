package designpattern.singleton;

/**
 * 饿汉式单例模式
 * 说明：
 * 饿汉式单例模式在类加载的时候就初始化，并创建单例对象。
 * 线程绝对安全，因为初始化在线程没出现之前，不存在访问安全问题。
 *
 * 优点：没有任何锁、执行效率高，用户体验比懒汉式单例模式更好。
 * 缺点：类加载就初始化，浪费内存，不管用不用都占用空间，俗称“占着茅坑不拉屎”。
 *
 * Spring中IOC容器ApplicationContext本身就是典型的饿汉式单例模式，ApplicationContext为应用上下文，高级形态的BeanFactory。
 *
 */
public class HungrySingleton {
    private static final HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton(){}

    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }
}

