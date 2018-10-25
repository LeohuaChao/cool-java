package me.leohuachao.cool.thread;

import java.util.concurrent.*;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/10/22
 */
public class ThreadPoolDemo {
    public static void main(String args[]) {

        //ExecutorService executorService = Executors.newCachedThreadPool(new MyThreadFactory());
        //ExecutorService executorService = Executors.newSingleThreadExecutor(new MyThreadFactory());
        ExecutorService executorService = Executors.newFixedThreadPool(3, new MyThreadFactory());
        System.out.println("init ExecutorService finished");

        executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName() + ": run jobs");
            }
        );
    }
}

class MyThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        System.out.println(Thread.currentThread().getName() + ": call ThreadFactory");
        return new Thread(r);
    }
}