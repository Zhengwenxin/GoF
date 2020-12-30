package designpattern.proxy.cglibproxy;

/**
 * CGLib代理测试代码
 */
public class CglibTest {
    public static void main(String[] args) {
        try {
            Customer obj = (Customer) new CglibMeipo().getInstance(Customer.class);
            obj.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
