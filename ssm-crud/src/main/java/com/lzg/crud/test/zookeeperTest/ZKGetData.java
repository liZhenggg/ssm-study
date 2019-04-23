package com.lzg.crud.test.zookeeperTest;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;

public class ZKGetData {

    private static ZooKeeper zk;
    private static ZooKeeperConnection conn;

    public static Stat znode_exists(String path)
            throws KeeperException, InterruptedException {
        return zk.exists(path, true);
    }

    public static void main(String[] args) {
        String path = "/MyFirstZnode";
        final CountDownLatch connectedSignal = new CountDownLatch(1);

        try {
            conn = new ZooKeeperConnection();
            zk = conn.connect("localhost");
            Stat stat = znode_exists(path);
            if (stat != null) {
                System.out.println("Node exists and the node version is "
                        + stat.getVersion());

                byte[] b = zk.getData(path, new Watcher() {
                    @Override
                    public void process(WatchedEvent watchedEvent) {
                        if (watchedEvent.getType() == Event.EventType.None) {
                            switch (watchedEvent.getState()) {
                                case Expired:
                                    System.out.println("doing countDown()...");
                                    connectedSignal.countDown();
                                    break;
                            }
                        } else {
                            try {
                                byte[] bn = zk.getData(path, false, null);
                                String data = new String(bn, "UTF-8");
                                System.out.println("get data:" + data);
                                connectedSignal.countDown();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, null);

                String data = new String(b, "UTF-8");
                System.out.println(data);
                connectedSignal.await();

            } else {
                System.out.println("Node does not exists");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
