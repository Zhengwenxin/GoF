package designpattern.singleton;

/**
 * 懒汉式单例模式
 * 说明：
 * 被外部类调用的时候内部类才会加载，即使用的时候才进行实例化。
 * 通过不断切换线程，可以观察到线程环境下LazySimpleSingleton被实例化了两次。
 * 虽然有时候看到是相同的两个对象，实际上是被后面执行的线程覆盖掉了。
 * 所以这种方式存在线程安全问题，但我们可以通过优化代码，使得懒汉式单例模式在线程环境下安全。
 * 可以通过在getInstance上加锁的方式。
 */
public class LazySimpleSingleton {

    private LazySimpleSingleton() {
    }

    private static LazySimpleSingleton lazy = null;

    //通过在实例化方法加锁可以保证线程安全。但是此方式在多线程环境下会导致CPU分配压力飙升，导致大批线程阻塞，性能下降。
    //为了兼顾线程安全和程序性能，可以使用双重检查锁的单例模式。
    public static LazySimpleSingleton getInstance() {
        if (null == lazy) {
            lazy = new LazySimpleSingleton();
        }
        return lazy;
    }

    //测试方法
    public static void main(String[] args) {
        Thread t1 = new Thread(new ExectorThread());
        Thread t2 = new Thread(new ExectorThread());
        t1.start();
        t2.start();
        System.out.println("End");
    }

}
