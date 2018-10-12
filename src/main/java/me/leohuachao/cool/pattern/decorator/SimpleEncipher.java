package me.leohuachao.cool.pattern.decorator;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/10/12
 */
public class SimpleEncipher implements Encipher {
    @Override
    public String encrypt(String str) {
        System.out.println("encrypt by Simple");
        return str;
    }
}
