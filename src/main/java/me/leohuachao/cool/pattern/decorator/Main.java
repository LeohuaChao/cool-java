package me.leohuachao.cool.pattern.decorator;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/10/12
 */
public class Main {
    public static void main(String args[]) {
        Encipher simple = new SimpleEncipher();
        Encipher complex = new ComplexEncipher();

        Encipher encipher = new CombineEncipher(simple, complex);

        Encipher e1 = new CombineEncipher(encipher, simple);

        encipher.encrypt("hello world");

        e1.encrypt("hello world");
    }
}
