package me.leohuachao.cool.jvm;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/9/18
 */
public class Foo {
    public static void main(String[] args) {
        boolean flag = true;
        if (flag) System.out.println("Hello world!");
        if (true == flag) {
            System.out.println("Hello JVM!");
        }
    }
}
