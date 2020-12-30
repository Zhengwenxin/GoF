package designpattern.proxy.dynamicproxy;

import designpattern.proxy.staticproxy.example.entity.Order;
import designpattern.proxy.staticproxy.example.service.IOrderService;
import designpattern.proxy.staticproxy.example.service.impl.OrderService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 数据源动态代理测试代码
 * 说明：
 * 使用动态代理后，不仅能实现Order的数据动态路由，还能实现其他任何类的数据源路由。
 * 必须实现getCreateTime方法，因为路由规则是按时间运算的，可以通过接口规范强制约束。
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
        try {
            Order order =new Order();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date date = sdf.parse("2020/12/30");
            order.setCreateTime(date.getTime());

            IOrderService orderService = (IOrderService) new OrderServiceDynamicProxy().getInstance(new OrderService());
            orderService.createOrder(order);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
