package me.leohuachao.cool.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/10/14
 */
public class Main {
    public static void main(String args[]) {
        IService service = new ServiceImpl();
        InvocationHandler handler = new ProxyHandler(service);

        IService proxy = (IService)Proxy.newProxyInstance(Main.class.getClassLoader(), new Class[]{IService.class}, handler);
        proxy.doThing();
    }
}
