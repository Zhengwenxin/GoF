package designpattern.singleton;


/**
 * 静态内部类方式的单例模式
 * 说明：
 * 这种形式兼顾了饿汉式单例模式的内存浪费问题和synchronized的性能问题
 *
 */
public class LazyInnerClassSingleton {
    //使用LazyInnerClassGeneral的时候，默认会先初始化内部类
    //如果没使用，则内部类不加载。
    private LazyInnerClassSingleton(){}

    //static是为了使单例的空间共享，保证这个方法不会被重写、重载。
    public static final LazyInnerClassSingleton getInstance(){
        //返回结果之前，一定会先加载内部类。
        return LazyHolder.LAZY;
    }

    //默认不加载
    private static class LazyHolder{
        private static final LazyInnerClassSingleton LAZY = new LazyInnerClassSingleton();
    }
}
