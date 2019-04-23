package com.lzg.crud.test.zookeeperTest;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

public class ZKCreate {

    private static ZooKeeper zk;
    private static ZooKeeperConnection conn;

    public static void create(String path, byte[] data)
            throws KeeperException, InterruptedException {
        zk.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT);
    }

    public static void main(String[] args) {
        String path = "/MyFirstZnode/mysecondsubmode";
        byte[] data = "mysecondsubmode".getBytes();

        try {
            conn = new ZooKeeperConnection();
            zk = conn.connect("localhost");
            create(path, data);
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
