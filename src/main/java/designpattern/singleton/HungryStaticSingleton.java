package designpattern.singleton;

/**
 * 这是饿汉模式的第二种写法，利用static静态代码块的方式
 */
public class HungryStaticSingleton {
    private static final HungryStaticSingleton hungrySingleton;

    static {
         hungrySingleton = new HungryStaticSingleton();
    }

    public static HungryStaticSingleton getInstance(){
        return hungrySingleton;
    }
}
