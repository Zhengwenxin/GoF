package designpattern.factory.simplefactory;

/**
 * 简单工厂
 * 客户端调用代码
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        //第一个版本的工厂调用
        CourseFactory factory1 = new CourseFactory();
        ICourse course1 = factory1.createV1("Java");
        course1.record();

        //第二个版本的工厂调用
        CourseFactory factory2 = new CourseFactory();
        ICourse course2 = factory2.createV2("designpattern.factory.simplefactory.JavaCourse");
        course2.record();

        //第三个版本的工厂调用
        CourseFactory factory3 = new CourseFactory();
        ICourse course3 = factory3.createV3(JavaCourse.class);
        course3.record();
    }
}
