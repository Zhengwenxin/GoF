package designpattern.factory.abstractfactory;

import designpattern.factory.factorymethod.ICourseFactory;
import designpattern.factory.simplefactory.ICourse;

public class JavaCourseFactory implements CourseFactory {

    @Override
    public INote createNote() {
        return new JavaNote();
    }

    @Override
    public IVideo createVideo() {
        return new JavaVideo();
    }

}
