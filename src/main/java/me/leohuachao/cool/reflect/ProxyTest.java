package me.leohuachao.cool.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/10/8
 */
public class ProxyTest {

    public static void main(String[] args) {
        A a = new RealA();

        B p = (B) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), new Class[]{B.class}, new HandlerA(a));

        p.doB();
    }

}

interface A {
    void doA();
}

interface B {
    void doB();
}

class RealA implements A, B {

    @Override
    public void doA() {
        System.out.println("do A");
    }

    @Override
    public void doB() {
        System.out.println("do B");
    }
}

class HandlerA implements InvocationHandler {

    A a;

    public HandlerA(A a) {
        this.a = a;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        System.out.println("before invoke");
        a.doA();
        return null;
    }
}