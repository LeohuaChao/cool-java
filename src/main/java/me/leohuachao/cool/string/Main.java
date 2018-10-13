package me.leohuachao.cool.string;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/10/14
 */
public class Main {
    public static void main(String args[]) {
        String a = new String("abc");
        String b = "abc";
        System.out.println(a == b);

        String c = new String("123");
        String e = c.intern();
        String d = "123";
        System.out.println(e == d);

        String h = new String("1") + new String("1");
    }
}
