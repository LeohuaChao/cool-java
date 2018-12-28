package me.leohuachao.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/12/18
 */
public class CollectionTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("3");
        list.add("2");

//        for (String str : list) {
//            if ("1".equals(str)) {
//                list.remove(str);
//            }
//        }

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            System.out.println(str);
            if ("3".equals(str)) {
                list.remove(str);
            }
        }
    }
}
