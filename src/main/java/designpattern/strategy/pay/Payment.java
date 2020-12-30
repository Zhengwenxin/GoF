package designpattern.strategy.pay;

public abstract class Payment {
    public abstract  String getName();

    protected abstract double queryBalance(String uid);
    public PayState pay (String uid,double amount){
        if (queryBalance(uid)<amount){
            return new PayState(500,"支付失败","余额不足");
        }
        return new PayState(200,"支付成功","支付余额："+amount);
    }
}
