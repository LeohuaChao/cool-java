package me.leohuachao.cool.java7;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/9/13
 */
public class SwitchStr {
    public static void main(String args[]) {

        String aa = "baidu";
        System.out.println(aa.hashCode());

        if (args.length < 1) {
            System.exit(1);
        }

        switch (args[0]) {
            case "baidu":
                System.out.println("www.baidu.com");
                break;
            case "google":
                System.out.println("www.google.com");
                break;
            default:
                    System.out.println("default");
        }
    }
}
