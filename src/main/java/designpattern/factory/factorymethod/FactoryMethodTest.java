package designpattern.factory.factorymethod;

import designpattern.factory.simplefactory.ICourse;

/**
 * 模板工厂模式的测试方法
 */
public class FactoryMethodTest {
    public static void main(String[] args) {
        ICourseFactory factory = new PythonCourseFactory();
        ICourse course = factory.create();
        course.record();

        factory = new JavaCourseFactory();
        course = factory.create();
        course.record();
    }
}
