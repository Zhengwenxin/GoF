package designpattern.factory.abstractfactory;

public class JavaNote implements INote {
    @Override
    public void edit() {
        System.out.println("录制Java笔记");
    }
}
