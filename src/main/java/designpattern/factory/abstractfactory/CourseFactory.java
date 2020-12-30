package designpattern.factory.abstractfactory;

public interface CourseFactory {
    INote createNote();
    IVideo createVideo();
}
