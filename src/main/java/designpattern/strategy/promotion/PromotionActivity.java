package designpattern.strategy.promotion;

import designpattern.strategy.promotion.strategy.PromotionStrategy;

/**
 * 创建促销方案类
 */
public class PromotionActivity {
    private PromotionStrategy promotionStrategy;
    public PromotionActivity(PromotionStrategy promotionStrategy){
        this.promotionStrategy = promotionStrategy;
    }
    public void excute(){
        promotionStrategy.doPromotion();
    }
}
