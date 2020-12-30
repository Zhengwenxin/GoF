package designpattern.proxy.jdkproxy;

import designpattern.proxy.staticproxy.Person;

/**
 * 单身客户类
 */
public class Customer implements Person {
    @Override
    public void findLove() {
        System.out.println("高富帅");
        System.out.println("身高180cm");
        System.out.println("有6块腹肌");
    }
}
