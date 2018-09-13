package me.leohuachao.cool.io;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/9/10
 */
public class Test {
    public static void main(String[] args) {
        try {
            String a = "b";
            String b = null;
            System.out.println(b.replace('a', 'b'));
        } catch(Exception ex) {
            System.out.println(ex);
            ex.printStackTrace(System.out);
        }

    }
}
