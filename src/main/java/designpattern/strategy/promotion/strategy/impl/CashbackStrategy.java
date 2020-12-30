package designpattern.strategy.promotion.strategy.impl;

import designpattern.strategy.promotion.strategy.PromotionStrategy;

public class CashbackStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("返现促销，返回的金额转到支付宝账号");
    }
}
