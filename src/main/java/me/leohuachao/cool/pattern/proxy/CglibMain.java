package me.leohuachao.cool.pattern.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/10/14
 */
public class CglibMain {
    public static void main(String args[]) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Hello.class);
        enhancer.setCallback(new MyMethodInterceptor());

        Hello obj = (Hello) enhancer.create();
        obj.sayHello();
    }

    static class MyMethodInterceptor implements MethodInterceptor {
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable{
            System.out.println("before invoke method: " + method.getName());
            //Object result = method.invoke(objects);
            Object result = methodProxy.invokeSuper(o, objects);
            return result;
        }
    }

    static class Hello {
        void sayHello() {
            System.out.println("hello world");
        }
    }

}
