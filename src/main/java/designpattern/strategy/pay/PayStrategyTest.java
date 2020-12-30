package designpattern.strategy.pay;

import designpattern.strategy.pay.payport.PayStrategy;

public class PayStrategyTest {
    public static void main(String[] args) {
        Order order = new Order("1","2020123100003200001394",34.23);
        System.out.println(order.pay(PayStrategy.ALI_PAY));
    }
}
