package designpattern.strategy.pay;

public class PayState {
    private int code;
    private Object data;
    private String msg;
    public PayState(int code,String msg,Object data){
        this.data =data;
        this.msg = msg;
        this.code =code;
    }

    @Override
    public String toString() {
        return "PayState{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
