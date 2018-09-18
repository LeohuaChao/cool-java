package me.leohuachao.cool.lambda;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/9/13
 */
public class Main {

    public static void main(String[] args) {

        test((i) -> {
            System.out.println("aa");
            System.out.println("22");
        });

        test(new Run<String>() {
            @Override
            public void test(String s) {
                System.out.println("aa");
            }
        });

        new Main(){};

        new Main(){}.tt();

        Main m = new Main(){};

//        () -> {};
//        () -> {}.tt();

        Run r = (n) -> {System.out.println(n.hashCode());};
        r.test(new Object());


    }

    public static void test(Run run) {
        System.out.println(run.getClass().getName());
        run.test(new Object());
    }

    public void tt() {

    }
}

@FunctionalInterface
interface Run<T> {
    void test(T s);
}

@FunctionalInterface
interface VVV {
    void test();
}

//@FunctionalInterface
//abstract class rr {
//    abstract void test();
//}