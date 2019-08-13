package com.luo.prototype.zk;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.Watcher.Event.KeeperState;
/**
 * @author luoxuzheng
 * @create 2019-08-13 13:01
 **/
public class ZookeeperClient {
    private static final int SESSION_TIME = 3000;
    private static ZooKeeper zookeeper = null;
    private static CountDownLatch latch;
    private static String zookeeperCluster;
    private static String appName;

    private ZookeeperClient() {
    }

    public static String getAppName() {
        return appName;
    }

    public static ZooKeeper getZooKeeper() {
        if (zookeeper == null) {
            Class var0 = ZookeeperClient.class;
            synchronized(ZookeeperClient.class) {
                if (zookeeper == null) {
                    latch = new CountDownLatch(1);
                    zookeeper = buildClient();

                    try {
                        latch.await(30L, TimeUnit.SECONDS);
                    } catch (InterruptedException var7) {
                        var7.printStackTrace();
                    } finally {
                        latch = null;
                    }
                }
            }
        }

        return zookeeper;
    }

    private static ZooKeeper buildClient() {
        try {
            return new ZooKeeper(zookeeperCluster, 3000, new ZookeeperClient.SessionWatcher());
        } catch (IOException var1) {
            return null;
        }
    }

    public static void close() {
        if (zookeeper != null) {
            try {
                zookeeper.close();
                zookeeper = null;
            } catch (InterruptedException var1) {
            }
        }

    }

    static {
        InputStream in = ZookeeperClient.class.getClassLoader().getResourceAsStream("zookeeper-config.properties");
        Properties properties = new Properties();

        try {
            if (in != null) {
                properties.load(in);
            }
        } catch (IOException var3) {
            var3.printStackTrace();
            zookeeperCluster = null;
        }

        zookeeperCluster = properties.getProperty("cluster");
        appName = properties.getProperty("application.name");
    }

    static class SessionWatcher implements Watcher {
        SessionWatcher() {
        }

        public void process(WatchedEvent event) {
            if (event.getState() == KeeperState.SyncConnected) {
                if (ZookeeperClient.latch != null) {
                    ZookeeperClient.latch.countDown();
                }
            } else if (event.getState() == KeeperState.Expired) {
                ZookeeperClient.close();
                ZookeeperClient.getZooKeeper();
            }

        }
    }
}
