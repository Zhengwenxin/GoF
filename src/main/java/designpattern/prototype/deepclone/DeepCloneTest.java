package designpattern.prototype.deepclone;

import designpattern.prototype.deepclone.QiTianDaSheng;

//深克隆浅克隆 测试代码
//可得到下面结果：
//深克隆：false
//浅克隆：true
//因此，浅克隆只是克隆的引用地址，引用对象还是指向原来的对象，所以浅克隆为true。
//而深克隆克隆的是数据，内存中真实的克隆出两个不同地址的对象，所以地址不同，深克隆为false。
public class DeepCloneTest {
    public static void main(String[] args) {
        try {
            QiTianDaSheng qiTianDaSheng1 = new QiTianDaSheng();
            QiTianDaSheng clone = (QiTianDaSheng) qiTianDaSheng1.deepClone();
            System.out.println("深克隆：" + (qiTianDaSheng1.jinGuBang == clone.jinGuBang));
        }catch (Exception e){
            e.printStackTrace();
        }

        QiTianDaSheng qiTianDaSheng2 = new QiTianDaSheng();
        QiTianDaSheng shallowClone = qiTianDaSheng2.shallowClone(qiTianDaSheng2);
        System.out.println("浅克隆："+(qiTianDaSheng2.jinGuBang==shallowClone.jinGuBang));
    }
}
