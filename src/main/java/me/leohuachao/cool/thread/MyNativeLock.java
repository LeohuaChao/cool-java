package me.leohuachao.cool.thread;

/**
 * 用Synchronized实现一个简单的锁，非公平、不支持重入
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/10/18
 */
public class MyNativeLock {

    private static Integer flag = 0;

    private volatile boolean blocked = false;

    private volatile Thread owner;

    public synchronized void lock() {
        while (blocked) {
            try {
                System.out.println(Thread.currentThread().getName() + " wait lock");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " get lock");
        blocked = true;
        owner = Thread.currentThread();
    }

    public synchronized void unlock() {
        if (blocked) {
            blocked = false;
            this.notify();
            System.out.println(Thread.currentThread().getName() + " un lock");
        }
    }

    public static void main(String args[]) {

        MyNativeLock lock = new MyNativeLock();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    lock.lock();
                    for (int j = 0; j < 1000; j++) {
                        flag = ++flag;
                    }
                    lock.unlock();
                }
            }).start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(flag);
    }
}
