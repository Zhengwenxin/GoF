package designpattern.strategy.promotion.factory;

import designpattern.strategy.promotion.strategy.*;
import designpattern.strategy.promotion.strategy.impl.CashbackStrategy;
import designpattern.strategy.promotion.strategy.impl.CouponStrategy;
import designpattern.strategy.promotion.strategy.impl.EmptyStrategy;
import designpattern.strategy.promotion.strategy.impl.GroupbuyStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * 当判断过多时，策略模式可以和工厂模式一起配合使用
 */
public class PromotionStrategyFactory {
    private static Map<String, PromotionStrategy> PROMOTION_STRATEGY_MAP=new HashMap<>();

    static{
        PROMOTION_STRATEGY_MAP.put(PromotionKey.COUPON,new CouponStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.CASHBACK,new CashbackStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.GROUPBUY,new GroupbuyStrategy());
    }

    private static  final PromotionStrategy NON_PROMOTION = new EmptyStrategy();

    private PromotionStrategyFactory(){}

    public  static PromotionStrategy getPromotionStrategy(String promotionKey){
        PromotionStrategy promotionStrategy = PROMOTION_STRATEGY_MAP.get(promotionKey);
        return promotionStrategy==null?NON_PROMOTION:promotionStrategy;
    }

    private interface PromotionKey{
        String COUPON ="COUNPON";
        String CASHBACK ="CASHBACK";
        String GROUPBUY ="GROUPBUY";
    }

}
