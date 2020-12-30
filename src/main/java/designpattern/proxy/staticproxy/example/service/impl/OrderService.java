package designpattern.proxy.staticproxy.example.service.impl;

import designpattern.proxy.staticproxy.example.entity.Order;
import designpattern.proxy.staticproxy.example.dao.OrderDao;
import designpattern.proxy.staticproxy.example.service.IOrderService;

public class OrderService implements IOrderService {
    private OrderDao orderDao;

    //这里使用spring是自动注入的，这里用构造方法直接将orderDao初始化
    public OrderService(){
        orderDao = new OrderDao();
    }
    @Override
    public int createOrder(Order order) {
        System.out.println("OrderService调用orderDao创建订单");
        return orderDao.insert(order);
    }
}
