package designpattern.strategy.promotion.strategy.impl;

import designpattern.strategy.promotion.strategy.PromotionStrategy;

public class EmptyStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("无促销活动");
    }
}
