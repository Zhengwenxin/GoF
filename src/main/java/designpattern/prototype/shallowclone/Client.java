package designpattern.prototype.shallowclone;

public class Client {
    private Prototype prototype;
    public Client(Prototype prototype){
        this.prototype = prototype;
    }

    public Prototype startClone(Prototype concretePrototype){
        return (Prototype) concretePrototype.clone();
    }
}
