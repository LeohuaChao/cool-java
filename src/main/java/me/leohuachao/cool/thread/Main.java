package me.leohuachao.cool.thread;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/10/15
 */
public class Main {
    public static void main(String args[]) throws Exception{
        Queue<Thread> queue = new LinkedList<>();

        Thread t1 = new Thread(new Printer(queue), "Thread 1");
        queue.add(t1);
        Thread t2 = new Thread(new Printer(queue), "Thread 2");
        queue.add(t2);
        Thread t3 = new Thread(new Printer(queue), "Thread 3");
        queue.add(t3);

        t1.start();
        t2.start();
        t3.start();

        t3.join();

        System.out.println("end");
    }
}

class Printer implements Runnable {

    private Queue<Thread> threadQueue;

    private static final Object lock = new Object();

    private static final Integer COUNT = 5;

    private static Integer index = 1;

    public Printer(Queue<Thread> queue) {
        this.threadQueue = queue;
    }

    @Override
    public void run() {
        synchronized (lock) {
            while (index < 75) {
                Thread nextThread = threadQueue.element();

                if (nextThread != Thread.currentThread()) {
                    lock.notifyAll();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    continue;
                }

                for (int i = 0; i < COUNT; i++) {
                    System.out.println(Thread.currentThread().getName() + ": " + index++);
                }

                threadQueue.add(threadQueue.poll());
            }
            lock.notifyAll();
        }
    }
}