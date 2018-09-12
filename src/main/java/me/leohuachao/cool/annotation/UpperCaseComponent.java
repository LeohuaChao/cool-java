package me.leohuachao.cool.annotation;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/9/12
 */
@Component(identifier="upper")
public class UpperCaseComponent {
    public String doWork(String str) {
        return null == str ? null : str.toUpperCase();
    }
}
