package designpattern.proxy.staticproxy.example.dao;

import designpattern.proxy.staticproxy.example.entity.Order;

public class OrderDao {
    public int insert(Order order){
        System.out.println("OrderDao 创建Order成功！");
        return 1;
    }
}
