package me.leohuachao.test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/12/19
 */
public class HashMapTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Map<Integer, String> map = new HashMap<>();

        for (int i = 1; i < 17; i++) {
            map.put(new Integer(i), "22");
        }

        Field f = HashMap.class.getDeclaredField("table");

        f.setAccessible(true);
        Object[] table = (Object[])f.get(map);

        System.out.println(table.length);
    }
}
