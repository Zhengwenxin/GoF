package designpattern.proxy.cglibproxy;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.cglib.core.DebuggingClassWriter;

/**
 * CGLib代理测试代码
 * 说明：
 * 关于CGLib代理和JDK代理的区别：
 * 1.JDK动态代理实现了被代理类的接口，CGLib代理继承了被代理对象。
 * 2.JDK动态代理和CGLib代理都是在运行期生成字节码，JDK动态代理直接写Class字节码，
 *   CGLib代理使用ASM框架写Class字节码，CGLib实现更复杂，生成代理类要比JDK动态代理效率低。
 * 3.JDK动态代理是通过反射调用的，CGLib代理通过FastClass机制直接调用方法，CGLib代理效率更高。
 *
 * 关于FastClass机制原理：
 * 为代理类和被代理类各生成一个类，这个类会为代理类或被代理类的方法分配一个index(int类型)，
 * 这个index作为入参，FastClass就可以直接定位要调用的方法并直接进行调用，省去了反射调用，所以会比JDK代理效率高。
 * FastClass并不是跟代理类一起生成的，而是在第一次执行MethodProxy的invoke()或invokeSuper()方法时生成的，并放在了缓存中。
 *
 */
public class CglibTest {
    public static void main(String[] args) {
        try {

            //利用CGLib的代理类可以将内存的.class文件写入到本地磁盘
            System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"E://cglib_proxy_class/");
            Customer obj = (Customer) new CglibMeipo().getInstance(Customer.class);
            obj.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
