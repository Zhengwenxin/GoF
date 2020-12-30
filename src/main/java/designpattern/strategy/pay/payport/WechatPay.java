package designpattern.strategy.pay.payport;

import designpattern.strategy.pay.Payment;

public class WechatPay extends Payment {
    @Override
    public String getName() {
        return "微信支付";
    }

    @Override
    protected double queryBalance(String uid) {
        return 256;
    }
}
