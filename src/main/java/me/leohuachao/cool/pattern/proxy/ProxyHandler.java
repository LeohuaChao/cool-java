package me.leohuachao.cool.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/10/14
 */
public class ProxyHandler implements InvocationHandler {

    private Object target;

    public ProxyHandler(Object target) {
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Exception{
        System.out.println("before invoke");
        Object result = method.invoke(target, args);
        System.out.println("end invoke");
        return result;
    }
}
