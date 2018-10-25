package me.leohuachao.cool.thread;

import java.util.concurrent.Semaphore;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/10/22
 */
public class SemaphoreDemo {
    public static void main(String args[]) {
        Semaphore semaphore = new Semaphore(5);

        for (int i = 0; i < 10; i++) {
            new Thread(new Worker(semaphore)).start();
        }
    }
}

class Worker implements Runnable {
    private Semaphore semaphore;

    public Worker(Semaphore semaphore) {
        this.semaphore = semaphore;
    }
    @Override
    public void run() {
        try {
            log("start acquire a permits");
            semaphore.acquire();
            log("acquire permits success");
            log("execute success");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            log("release the permits");
            semaphore.release();
        }
    }

    private void log(String msg) {
        System.out.println(Thread.currentThread().getName() + ": " + msg);
    }
}
