package me.leohuachao.cool.annotation;

import java.lang.annotation.*;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/9/12
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
@Inherited
public @interface Component {
    String identifier();
}
