package me.leohuachao.cool.thread;

/**
 * 两个线程交替打印奇偶数
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/10/17
 */
public class Main0 {

    private static volatile int flag = 1;

    private static final Object LOCK = new Object();

    public static void main(String args[]) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (LOCK) {

                    while (flag <= 100) {
                        if (flag % 2 == 0) {
                            System.out.println(Thread.currentThread().getName() + " " + flag++);
                        }

                        LOCK.notify();
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (LOCK) {

                    while (flag <= 100) {
                        if (flag % 2 != 0) {
                            System.out.println(Thread.currentThread().getName() + " " + flag++);
                        }
                        LOCK.notify();
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }
}
