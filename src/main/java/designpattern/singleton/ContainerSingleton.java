package designpattern.singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 容器式单例模式
 * 说明：
 * 又称注册式单例模式，这种方式便于管理，但是是非线程安全的。
 * Spring中的IOC类，AbstractAutowireCapableBeanFactory类中就用了这种方式来存放FactoryBean未使用的缓存实例。源码如下：
 * public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory
 *          implements AutowireCapableBeanFactory{
 *     private final Map<String,BeanWrapper> factoryBeanInstanceCache = new ConcurrentHashMap<>(16);
 * }
 *
 */
public class ContainerSingleton {
    private ContainerSingleton(){}
    private static Map<String,Object> ioc = new ConcurrentHashMap<String,Object>();
    public static Object getBean(String className){
        synchronized (ioc){
            if (!ioc.containsKey(className)){
                Object obj =null;
                try{
                    obj = Class.forName(className).newInstance();
                    ioc.put(className,obj);
                } catch (Exception e){
                    e.printStackTrace();
                }
                return obj;
            } else{
                return  ioc.get(className);
            }
        }
    }

}
