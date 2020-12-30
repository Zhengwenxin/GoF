package designpattern.strategy.promotion.strategy.impl;

import designpattern.strategy.promotion.strategy.PromotionStrategy;

public class CouponStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("领取优惠券，商品价格直接减优惠券面值抵扣");
    }
}
