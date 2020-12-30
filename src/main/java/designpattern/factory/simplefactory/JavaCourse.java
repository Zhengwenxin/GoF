package designpattern.factory.simplefactory;

public class JavaCourse  implements ICourse{
    @Override
    public  void record() {
        System.out.println("录制Java课程");
    }
}
