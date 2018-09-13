package me.leohuachao.cool.generic;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/9/13
 */
public class Main {

    public static <T> T isNull(T t) {
        if (null == t) {
            return null;
        }

        return t;
    }

    public static void main(String[] args) throws NoSuchMethodException{

        Method[] allMethods = Main.class.getDeclaredMethods();
        for (Method method : allMethods) {
           System.out.println(method);
        }

        List<?> list = new ArrayList();
        //Object o = list.get(0);

        List<? extends Base> ll = new ArrayList();
//        ll.add(new Base());
//        ll.add(new Sub());
        ll.add(null);
//        ll.add(new Object());
        for (Base b : ll) {
            b.say();
        }

        List<? super Sub> l2 = new ArrayList();
//        l2.add(new Base());
        l2.add(new Sub());
        l2.add(null);
//        l2.add(new Object());
        l2.add(new Sub1());
        for (Object b : l2) {
            b.toString();
        }
    }

    public static void test_generic_extends(Collection<? extends Base> b) {

    }

    public static void test_generic_super(Collection<? super Base> b) {

    }

}

class Base {
    String say() {
        return "Base";
    }
}

class Sub extends Base {
    @Override
    String say() {
        return super.say();
    }
}

class Sub1 extends Sub {
}