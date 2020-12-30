package designpattern.factory.factorymethod;

import designpattern.factory.simplefactory.ICourse;

/**
 * 在简单工厂中，工厂类职责并没有区分，根据单一职责原则我们将职能进行拆分，专人干专事。
 * Java课程由Java工厂创建，Python课程由Python工厂创建，对工厂本身也做一个抽象。
 */
public interface ICourseFactory {
    ICourse create();
}
