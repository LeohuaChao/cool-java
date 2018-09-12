package me.leohuachao.cool.annotation;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/9/12
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException{
        Class componentCLass = Class.forName("me.leohuachao.cool.annotation.UpperCaseComponent");
        if (componentCLass.isAnnotationPresent(Component.class)) {
            Component component = (Component) componentCLass.getAnnotation(Component.class);
            String identifer = component.identifier();
            System.out.println(String.format("load in Component identifer: %s", identifer));
        } else {
            System.out.println("load in class not annotation by component");
        }
    }
}
