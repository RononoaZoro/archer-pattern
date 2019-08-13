package com.luo.prototype.util;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;

import com.luo.prototype.zk.ZookeeperClient;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * @author luoxuzheng
 * @create 2019-08-13 12:55
 **/
public class PropertiesConfigUtils {
    private static final Logger logger = Logger.getLogger(PropertiesConfigUtils.class);
    private static volatile Properties PROPERTIES;
    private static final String SYSTEMGLOBALS = "/SystemGlobals/";

    private PropertiesConfigUtils() {
    }

    public static Properties getProperties() {
        if (PROPERTIES == null) {
            Class var0 = PropertiesConfigUtils.class;
            synchronized(PropertiesConfigUtils.class) {
                if (PROPERTIES == null) {
                    String path = System.getProperty("SystemGlobals.properties");
                    if (path == null || path.length() == 0) {
                        path = System.getenv("SystemGlobals.properties");
                        if (path == null || path.length() == 0) {
                            path = "SystemGlobals.properties";
                        }
                    }

                    PROPERTIES = loadProperties(path, false, true);
                }
            }
        }

        return PROPERTIES;
    }

    public static void addProperties(Properties properties) {
        if (properties != null) {
            getProperties().putAll(properties);
        }

    }

    public static void setProperties(Properties properties) {
        if (properties != null) {
            PROPERTIES = properties;
        }

    }

    public static String getProperty(String key) {
        return getProperty(key, (String)null);
    }

    public static String getProperty(String key, String defaultValue) {
        String value = System.getProperty(key);
        if (value != null && value.trim().length() == 0) {
            return null;
        } else if (value != null) {
            return value;
        } else {
            Properties properties = getProperties();
            value = properties.getProperty(key);
            if (StringUtils.isNotBlank(value)) {
                return value;
            } else {
                try {
                    ZooKeeper zooKeeper = ZookeeperClient.getZooKeeper();
                    String path = "/SystemGlobals/" + ZookeeperClient.getAppName() + "/" + key;
                    if (zooKeeper.exists(path, (Watcher)null) != null) {
                        value = new String(zooKeeper.getData(path, false, (Stat)null));
                    }
                } catch (KeeperException var6) {
                    var6.printStackTrace();
                    logger.error("load systemglobals property error", var6);
                } catch (InterruptedException var7) {
                    var7.printStackTrace();
                    logger.error("load systemglobals property error", var7);
                } catch (Exception var8) {
                    var8.printStackTrace();
                    logger.error("load systemglobals property error", var8);
                    if (defaultValue == null) {
                        properties.setProperty(key, "");
                    } else {
                        properties.setProperty(key, defaultValue);
                    }
                }

                if (StringUtils.isNotBlank(value)) {
                    properties.setProperty(key, value);
                    return value;
                } else {
                    return defaultValue;
                }
            }
        }
    }

    public static Properties loadProperties(String fileName) {
        return loadProperties(fileName, false, false);
    }

    public static Properties loadProperties(String fileName, boolean allowMultiFile) {
        return loadProperties(fileName, allowMultiFile, false);
    }

    public static Properties loadProperties(String fileName, boolean allowMultiFile, boolean optional) {
        Properties properties = new Properties();
        if (fileName.startsWith("/")) {
            try {
                FileInputStream input = new FileInputStream(fileName);

                try {
                    properties.load(input);
                } finally {
                    input.close();
                }
            } catch (Throwable var28) {
                logger.warn("Failed to load " + fileName + " file from " + fileName + "(ingore this file): " + var28.getMessage(), var28);
            }

            return properties;
        } else {
            ArrayList list = new ArrayList();

            try {
                Enumeration<URL> urls = PropertiesConfigUtils.class.getClassLoader().getResources(fileName);
                list = new ArrayList();

                while(urls.hasMoreElements()) {
                    list.add(urls.nextElement());
                }
            } catch (Throwable var33) {
                logger.warn("Fail to load " + fileName + " file: " + var33.getMessage(), var33);
            }

            if (list.size() == 0) {
                if (!optional) {
                    logger.warn("No " + fileName + " found on the class path.");
                }

                return properties;
            } else if (!allowMultiFile) {
                if (list.size() > 1) {
                    String errMsg = String.format("only 1 %s file is expected, but %d dubbo.properties files found on class path: %s", fileName, list.size(), list.toString());
                    logger.warn(errMsg);
                }

                try {
                    properties.load(PropertiesConfigUtils.class.getClassLoader().getResourceAsStream(fileName));
                } catch (Throwable var29) {
                    logger.warn("Failed to load " + fileName + " file from " + fileName + "(ingore this file): " + var29.getMessage(), var29);
                }

                return properties;
            } else {
                logger.info("load " + fileName + " properties file from " + list);
                Iterator i$ = list.iterator();

                while(i$.hasNext()) {
                    URL url = (URL)i$.next();

                    try {
                        Properties p = new Properties();
                        InputStream input = url.openStream();
                        if (input != null) {
                            try {
                                p.load(input);
                                properties.putAll(p);
                            } finally {
                                try {
                                    input.close();
                                } catch (Throwable var30) {
                                }

                            }
                        }
                    } catch (Throwable var32) {
                        logger.warn("Fail to load " + fileName + " file from " + url + "(ingore this file): " + var32.getMessage(), var32);
                    }
                }

                return properties;
            }
        }
    }

    public static void setProperty(String key, String value) {
        Properties properties = getProperties();
        properties.setProperty(key, value);
    }
}

