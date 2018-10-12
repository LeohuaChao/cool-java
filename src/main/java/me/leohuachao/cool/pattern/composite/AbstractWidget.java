package me.leohuachao.cool.pattern.composite;

import java.util.Collection;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/10/12
 */
public abstract class AbstractWidget {
    abstract void add(AbstractWidget widget);

    abstract void remove(AbstractWidget widget);

    abstract Collection<AbstractWidget> getChilds();

    abstract void operation();
}
