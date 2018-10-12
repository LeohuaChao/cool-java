package me.leohuachao.cool.pattern.decorator;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/10/12
 */
public class CombineEncipher extends Decorator {
    private Encipher encipher;

    public CombineEncipher(Encipher e1, Encipher e2) {
        super(e1);
        this.encipher = e2;
    }

    @Override
    public String encrypt(String string) {
        return this.encipher.encrypt(super.encrypt(string));
    }
}
