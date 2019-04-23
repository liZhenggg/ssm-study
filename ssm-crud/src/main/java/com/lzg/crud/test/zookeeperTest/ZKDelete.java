package com.lzg.crud.test.zookeeperTest;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

public class ZKDelete {
    private static ZooKeeper zk;
    private static ZooKeeperConnection conn;

    public static void delete(String path) throws KeeperException, InterruptedException {
        zk.delete(path, zk.exists(path, true).getVersion());
    }

    public static void main(String[] args) throws InterruptedException, KeeperException {
        String path = "/MyFirstZnode";

        try {
            conn = new ZooKeeperConnection();
            zk = conn.connect("localhost");
            delete(path);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
