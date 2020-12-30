package designpattern.strategy.pay.payport;

import designpattern.strategy.pay.Payment;

import java.util.HashMap;
import java.util.Map;

public class PayStrategy {
    public static  final String ALI_PAY  = "AliPay";
    public static  final String UNION_PAY  = "UnionPay";
    public static  final String WECHAT_PAY  = "WechatPay";
    public static  final String DEFAULT_PAY  = ALI_PAY;

    private static Map<String, Payment> payStrategy = new HashMap<>();
    static{
        payStrategy.put(ALI_PAY,new AliPay());
        payStrategy.put(WECHAT_PAY,new WechatPay());
        payStrategy.put(UNION_PAY,new UnionPay());
    }
    public static Payment get(String payKey){
        if (!payStrategy.containsKey(payKey)){
            return payStrategy.get(DEFAULT_PAY);
        }
        return payStrategy.get(payKey);
    }

}
