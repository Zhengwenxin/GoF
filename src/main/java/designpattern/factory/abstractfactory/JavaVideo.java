package designpattern.factory.abstractfactory;

public class JavaVideo implements IVideo{
    @Override
    public void record() {
        System.out.println("录制Java视频");
    }
}
