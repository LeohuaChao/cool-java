package me.leohuachao.cool.pattern.singleton;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/10/12
 */
public class Singleton {

    private Singleton() {

    }

    private static class Holder {
       static final Singleton INSTANCE = new Singleton();
    }

    public Singleton getInstance() {
        return Holder.INSTANCE;
    }

}
