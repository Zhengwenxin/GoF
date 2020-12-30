package designpattern.strategy.promotion;

import designpattern.strategy.promotion.factory.PromotionStrategyFactory;
import designpattern.strategy.promotion.strategy.impl.CashbackStrategy;
import designpattern.strategy.promotion.strategy.impl.CouponStrategy;
import org.thymeleaf.util.StringUtils;

public class PromotionTest {
    public static void main(String[] args) {
        V1();
        V2();
        V3();
    }

    private static void V1() {
        PromotionActivity promotionActivity = new PromotionActivity(new CouponStrategy());
        PromotionActivity promotionActivity1 = new PromotionActivity(new CashbackStrategy());

        promotionActivity.excute();
        promotionActivity1.excute();
    }

    private static void V2() {
        PromotionActivity promotionActivity = null;
        String promotionKey = "COUPON";
        if (StringUtils.equals(promotionKey, "COUPON")) {
            promotionActivity = new PromotionActivity(new CouponStrategy());
        } else if (StringUtils.equals(promotionKey, "CASHBACK")) {
            promotionActivity = new PromotionActivity(new CashbackStrategy());
        }
        promotionActivity.excute();
    }

    private static void V3() {
        String promotionKey = "GROUPBUY";
        PromotionActivity promotionActivity = new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy(promotionKey));
        promotionActivity.excute();
    }
}
