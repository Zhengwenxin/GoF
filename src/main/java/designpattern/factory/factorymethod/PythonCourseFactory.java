package designpattern.factory.factorymethod;

import designpattern.factory.simplefactory.ICourse;
import designpattern.factory.simplefactory.PythonCourse;

public class PythonCourseFactory implements ICourseFactory {
    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}
