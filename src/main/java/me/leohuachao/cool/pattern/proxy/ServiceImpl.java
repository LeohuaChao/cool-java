package me.leohuachao.cool.pattern.proxy;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/10/14
 */
public class ServiceImpl implements IService {
    @Override
    public void doThing() {
        System.out.println("ServiceImpl do thing");
    }
}
