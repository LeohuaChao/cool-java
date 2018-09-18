package me.leohuachao.cool.java8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/9/14
 */
public class Main {

    public static void main(String[] args) {
        B b = () -> {};
//        B.tt();
        b.test();

        List<? extends Object> a = new ArrayList();
        a.add(null);
    }
}

@FunctionalInterface
interface A {

    void func();

    default void test() {
        System.out.println("test from A");
    }

    static void tt() {
        System.out.println("tt from A");
    }
}

interface B extends A {

}