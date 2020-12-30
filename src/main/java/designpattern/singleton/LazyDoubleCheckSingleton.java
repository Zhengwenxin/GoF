package designpattern.singleton;

/**
 * 双重检查锁的单例模式
 * 说明：
 * 这种方式是懒汉模式的加强版，当多线程环境下，第一个线程调用getInstance方法，第二个线程也可以调用。
 * 但是，当第一个线程执行到synchronized时就会上锁，第二个线程变为MONITOR状态，出现阻塞。
 * 其实这种方式只是将阻塞由方法变为了方法内部的阻塞。
 * 但始终是用到锁，所以对性能还是有影响。
 * 我们有更好的方案，即静态内部类的方式。
 */
public class LazyDoubleCheckSingleton {
    private volatile static LazyDoubleCheckSingleton lazy = null;

    private LazyDoubleCheckSingleton(){}
    public LazyDoubleCheckSingleton getInstance(){
        if (null==lazy){
            synchronized (LazyDoubleCheckSingleton.class){
                if (null == lazy){
                    lazy = new LazyDoubleCheckSingleton();
                }
            }
        }

        return lazy;
    }
}
