package me.leohuachao.cool.reflect;

import java.lang.reflect.Field;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/9/27
 */
public class StringModify {
    public static void main(String[] args) throws InstantiationException, ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
        String s1 = "www.aa1.com";
        String s2 = "www.aa1.com";

        Field f = s1.getClass().getDeclaredField("value");
        f.setAccessible(true);
        ((char[]) f.get(s1))[6] = '3';

        System.out.println("s1 == " + s1);
        System.out.println("s2 == " + s2);
        System.out.println("s1 == s2 => " + (s1 == s2));

        Class clazz = Class.forName("me.leohuachao.cool.reflect.StringModify");
        Object object = clazz.newInstance();

        Class<String> c = null;
        String s = c.newInstance();
    }
}
