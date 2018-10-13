package me.leohuachao.cool.classloader;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/10/11
 */
public class Main {
    public static void main(String args[]) {

        System.out.println(Main.class.getClassLoader().getClass().getName());
        System.out.println(Main.class.getClassLoader().getParent().getClass().getName());
    }
}
