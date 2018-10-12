package me.leohuachao.cool.pattern.decorator;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/10/12
 */
public abstract class Decorator implements Encipher{
    private Encipher encipher;

    @Override
    public String encrypt(String string) {
        return encipher.encrypt(string);
    }

    public Decorator(Encipher encipher) {
        this.encipher = encipher;
    }
}
