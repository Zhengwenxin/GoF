package designpattern.proxy.cglibproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLib代理
 * 说明：
 * 这里继承了MethodInterceptor方法拦截器，
 */
public class CglibMeipo implements MethodInterceptor {

    public Object getInstance(Class<?> clazz) throws Exception {
        //Enhancer是一个字节码增强器，可以用来为无接口的类创建代理，它的功能与Java自带的Proxy类相似，
        //它会根据某个给定的类创建子类，并且所有非final的方法都带有回调钩子。
        Enhancer enhancer = new Enhancer();
        //根据某个给定的类创建子类
        enhancer.setSuperclass(clazz);
        //Enhancer的回调有下列几种方式：
        //1.Callback-MethodInterceptor
        //2.Callback-NoOp
        //3.Callback-LazyLoader
        //4.Callback-Dispatcher
        //5.Callback-InvocationHandler
        //6.Callback-FixedValue
        //7.CallbackFilter
        enhancer.setCallback(this);
        return enhancer.create();
    }

    private void before() {
        System.out.println("我是媒婆：我要给你找对象，现在已经确认你的需求");
        System.out.println("开始物色...");
    }

    private void after() {
        System.out.println("如何合适的话，就准备办事。");
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //业务的增强
        before();
        //
        Object obj = methodProxy.invokeSuper(o, objects);
        after();
        return obj;
    }
}
