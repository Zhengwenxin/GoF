package designpattern.proxy.dynamicproxy;

import designpattern.proxy.staticproxy.example.DynamicDataSourceEntry;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 数据源动态代理类
 * 说明：
 * 代理需要实现InvocationHandler的invoke方法，每一个动态代理类的调用处理程序都必须实现InvocationHandler接口，
 * 并且每个代理类的实例都关联到了实现该接口的动态代理类调用处理程序中，当我们通过动态代理对象调用一个方法时候，
 * 这个方法的调用就会被转发到实现InvocationHandler接口类的invoke方法来调用。
 *
 * Spring中代理模式的应用：
 *  ProxyFactoryBean的getObject()方法的实现就应用了代理模式。
 *  Spring利用动态代理实现AOP有两个类 JdkDynamicAopProxy和CglibAopProxy类，就是JDK动态代理和CGLib代理。
 */
public class OrderServiceDynamicProxy implements InvocationHandler {

    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    private Object target;

    public Object getInstance(Object target) throws Exception {
        this.target = target;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    private void before(Object target) {
        try {
            System.out.println("Proxy before method.");
            Long time = (Long) target.getClass().getMethod("getCreateTime").invoke(target);
            Integer dbRouter = Integer.valueOf(yearFormat.format(new Date(time)));
            System.out.println("动态代理类自动分配到【DB"+dbRouter+"】数据源处理数据");
            DynamicDataSourceEntry.set(dbRouter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void after() {
        System.out.println("Proxy after method.");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before(args[0]);
        Object object = method.invoke(target,args);
        after();
        return object;
    }
}
