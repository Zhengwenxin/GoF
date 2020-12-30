package designpattern.strategy.pay.payport;

import designpattern.strategy.pay.Payment;

public class AliPay extends Payment {
    @Override
    public String getName() {
        return "支付宝";
    }

    @Override
    protected double queryBalance(String uid) {
        return 900;
    }
}
