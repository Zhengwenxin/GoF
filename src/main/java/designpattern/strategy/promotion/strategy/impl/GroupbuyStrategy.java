package designpattern.strategy.promotion.strategy.impl;

import designpattern.strategy.promotion.strategy.PromotionStrategy;

public class GroupbuyStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("拼团，满10人享受团购价");
    }
}
