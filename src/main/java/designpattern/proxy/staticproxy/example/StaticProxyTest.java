package designpattern.proxy.staticproxy.example;

import designpattern.proxy.staticproxy.example.entity.Order;
import designpattern.proxy.staticproxy.example.proxy.OrderServiceStaticProxy;
import designpattern.proxy.staticproxy.example.service.IOrderService;
import designpattern.proxy.staticproxy.example.service.impl.OrderService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 静态代理测试代码
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        try {
            Order order =new Order();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date date = sdf.parse("2020/12/30");
            order.setCreateTime(date.getTime());

            IOrderService orderService =  new OrderServiceStaticProxy(new OrderService());
            orderService.createOrder(order);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
