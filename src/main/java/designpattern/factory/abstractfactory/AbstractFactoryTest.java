package designpattern.factory.abstractfactory;

/**
 * 抽象工厂模式测试方法
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        JavaCourseFactory factory = new JavaCourseFactory();
        factory.createNote().edit();
        factory.createVideo().record();
    }
}
