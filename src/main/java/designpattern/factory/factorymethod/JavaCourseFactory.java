package designpattern.factory.factorymethod;

import designpattern.factory.simplefactory.ICourse;
import designpattern.factory.simplefactory.JavaCourse;

public class JavaCourseFactory implements  ICourseFactory {
    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
