package me.leohuachao.test;

import me.leohuachao.cool.zk.ZkLock;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/12/27
 */
public class LockTest {
    public static volatile Integer flag = 0;

    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(3);
        CyclicBarrier barrier = new CyclicBarrier(3);

        Runnable task = () -> {
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            Lock lock = null;
            try {
                lock = new ZkLock("aaa");
                while (true) {
                    if (lock.tryLock()) {
                        for (int i = 0; i < 10000; i++) {
                            flag++;
                        }
                        break;
                    }
                }

            } finally {
                if (null != lock) {
                    lock.unlock();
                }
                latch.countDown();
            }

        };

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(task);
        executorService.submit(task);
        executorService.submit(task);

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();

        System.out.println(flag);

    }
}
