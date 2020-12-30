package designpattern.proxy.staticproxy.example.proxy;

import designpattern.proxy.staticproxy.example.DynamicDataSourceEntry;
import designpattern.proxy.staticproxy.example.entity.Order;
import designpattern.proxy.staticproxy.example.service.IOrderService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderServiceStaticProxy implements IOrderService {

    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

    private IOrderService orderService;
    public OrderServiceStaticProxy(IOrderService orderService){
        this.orderService = orderService;
    }

    @Override
    public int createOrder(Order order) {
        before();
        Long time = order.getCreateTime();
        Integer dbRouter =Integer.valueOf(yearFormat.format(new Date(time)));
        System.out.println("静态代理类自动分配到【DB_"+dbRouter+"】数据源处理数据");
        DynamicDataSourceEntry.set(dbRouter);
        orderService.createOrder(order);
        after();
        return 0;
    }

    private void after() {
        System.out.println("Proxy after method.");
    }

    private void before() {
        System.out.println("Proxy before method.");
    }


}
