package me.leohuachao.cool.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author leohuachao
 * @version V1.0
 * @Description: TODO
 * @date 2018/12/26
 */
public class ZkLock implements Lock, Watcher {

    private static ZooKeeper zk;

    public static final String ZKURL = "localhost:2181";

    public static final String ZKROOT = "/locks";


    static {
        try {
            CountDownLatch connectedSignal = new CountDownLatch(1);
            //zk = new ZooKeeper(ZKURL, 5000, null);
            zk = new ZooKeeper(ZKURL, 5000, (event) -> {
                System.out.println("event:" + event);
                if (event.getState() == Event.KeeperState.SyncConnected) {
                    connectedSignal.countDown();
                }
            });
            connectedSignal.await();
            // init root path
            Stat stat = zk.exists(ZKROOT, false);
            if (null == stat) {
                zk.create(ZKROOT, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }

        } catch (IOException | KeeperException | InterruptedException ex) {
            ex.printStackTrace();
            System.err.println("Zookeeper init failed!");
        }
    }

    private String lockName;

    private String myNode;

    public ZkLock(String lockName) {

        if (null == lockName || lockName.isEmpty()) {
            throw new IllegalArgumentException();
        }

        this.lockName = lockName;
    }

    @Override
    public void lock() {

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {

        if (null == this.myNode) {
            try {
                String myNode = zk.create(ZKROOT + "/" + lockName, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);

                this.myNode = myNode;
            } catch (InterruptedException | KeeperException ex) {
                ex.printStackTrace();
                return false;
            }

        }

        try {
            List<String> subNodes = zk.getChildren(ZKROOT, false);

            List<String> allNodes = new ArrayList<>();
            for (String node : subNodes) {
                if (node.contains(lockName)) {
                    allNodes.add(node);
                }
            }

            Collections.sort(allNodes);

            if (myNode.equals(ZKROOT + "/" + allNodes.get(0))){
                System.out.println("acquire lock success! " + myNode);
                return true;
            } else {
                System.out.println("acquire lock failed! " + myNode);
                return false;
            }
        } catch (InterruptedException | KeeperException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

        if (null != myNode) {
            try {
                zk.delete(myNode, -1);
                System.out.println("unlock successed! " + myNode);
            } catch (InterruptedException | KeeperException ex) {
                ex.printStackTrace();
                System.err.println("unlock failed! " + myNode);
            }

            this.myNode = null;
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
    }

}
