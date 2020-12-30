package designpattern.strategy.pay.payport;

import designpattern.strategy.pay.Payment;

public class UnionPay extends Payment {
    @Override
    public String getName() {
        return "银联支付";
    }

    @Override
    protected double queryBalance(String uid) {
        return 120;
    }
}
