package designpattern.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 枚举式单例模式
 * 说明：
 * 注册式单例模式又称登记式单例模式，具体意思就是将实例登记到某个地方存起来，然后使用标识来获取实例。
 * 注册式单例模式分两种：一种为枚举式单例模式，另一种为容器式单例模式。
 * 枚举式单例模式在静态代码中就为INSTANCE进行了赋值，因此是饿汉式单例的一种。
 *
 * 因为实现方式为枚举，反射无法破坏枚举式单例模式，Constructor的newInstance方法源码中做了强制判断，JDK源码如下：
 * if((clazz.getModifiers() & Modifier.ENUM) != 0)
 *  throw new IllegalArgumentException("Cannot reflectively create enum objects")
 *
 * 这种方法也是Effective Java中推荐的单例模式的实现方式。JDK枚举的语法特性和反射也保证了枚举无法被反射，
 * 这让枚举式单例模式成为一种比较优雅的单例模式实现方式。
 *
 */
public enum EnumSigleton {
    INSTANCE;
    private Object data;
    public Object getData(){
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public static EnumSigleton getInstance(){
        return INSTANCE;
    }

    //测试代码
    public static void main(String[] args) {
        try{
            EnumSigleton instance1 =null;

            EnumSigleton instance2 =EnumSigleton.getInstance();
            instance2.setData(new Object());

            FileOutputStream fos = new FileOutputStream("EnumSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(instance2);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("EnumSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            instance1= (EnumSigleton) ois.readObject();
            ois.close();

            System.out.println(instance1.getData());
            System.out.println(instance2.getData());
            System.out.println(instance1.getData() == instance2.getData());

        }catch (Exception e){}
    }
}
