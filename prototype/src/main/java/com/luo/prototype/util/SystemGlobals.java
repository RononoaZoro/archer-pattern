package com.luo.prototype.util;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.naming.Context;
import javax.naming.InitialContext;
import org.apache.commons.lang3.StringUtils;


/**
 * @author luoxuzheng
 * @create 2019-08-13 12:48
 **/
public class SystemGlobals {
    private static Properties preferences = null;
    private static Properties queries = new Properties();
    private static JndiApp jndiAppConfig = null;
    private static String configFile = "SystemGlobals.properties";

    public SystemGlobals() {
    }

    private static synchronized void init() {
        if (preferences == null) {
            preferences = new Properties();

            try {
                String fileName = configFile;

                String key;
                try {
                    Context initCtx = new InitialContext();
                    Context envCtx = (Context)initCtx.lookup("java:comp/env");
                    JndiApp bean = (JndiApp)envCtx.lookup("bean/MyBeanFactory");
                    jndiAppConfig = bean;
                    if (jndiAppConfig != null) {
                        key = jndiAppConfig.getAppDomain();
                        if (StringUtils.isNotBlank(key)) {
                            String[] configFileArr = configFile.split("\\.");
                            fileName = configFileArr[0] + "_" + key + "." + configFileArr[1];
                        }
                    }
                } catch (Exception var6) {
                }

                InputStream is = SystemGlobals.class.getClassLoader().getResourceAsStream(fileName);
                if (is != null) {
                    Properties p = new Properties();
                    p.load(is);
                    Enumeration enu = p.keys();
                    key = "";

                    while(enu.hasMoreElements()) {
                        key = (String)enu.nextElement();
                        preferences.put(key, (String)p.get(key));
                    }
                }
            } catch (Exception var7) {
            }

        }
    }

    public static String getDomain() {
        if (preferences == null) {
            init();
        }

        String domain = null;
        if (jndiAppConfig != null) {
            domain = jndiAppConfig.getAppDomain();
        }

        return domain;
    }

    public static String getPreference(String key) {
        if (preferences == null) {
            init();
        }

        String s = preferences.getProperty(key);
        if (s != null) {
            s = s.trim();
        } else {
            s = PropertiesConfigUtils.getProperty(key);
        }

        return s;
    }

    public static String getPreference(String key, String defaultValue) {
        if (preferences == null) {
            init();
        }

        String s = preferences.getProperty(key);
        if (s == null) {
            s = PropertiesConfigUtils.getProperty(key, defaultValue);
        }

        return s;
    }

    public static String getPreference(String key, Object... params) {
        if (preferences == null) {
            init();
        }

        String message = preferences.getProperty(key);
        if (message != null) {
            message = message.trim();
        } else {
            message = PropertiesConfigUtils.getProperty(key);
        }

        if (params != null && params.length != 0) {
            String[] ss = new String[params.length];
            Object o = null;

            for(int i = 0; i < params.length; ++i) {
                o = params[i];
                if (o == null) {
                    ss[i] = "";
                } else {
                    ss[i] = o.toString();
                }
            }

            return replacePlaceHolder(message, ss);
        } else {
            return message;
        }
    }

    public static void setPreference(String key, String value) {
        if (preferences == null) {
            init();
        }

        if (value != null) {
            value = value.trim();
            preferences.setProperty(key, value);
        } else {
            preferences.remove(key);
        }

    }

    public static int getIntPreference(String key, int defaultValue) {
        if (preferences == null) {
            init();
        }

        String s = getPreference(key);
        return StringUtils.isBlank(s) ? defaultValue : Integer.parseInt(s);
    }

    public static void setIntPreference(String key, int value) {
        if (preferences == null) {
            init();
        }

        setPreference(key, String.valueOf(value));
    }

    public static long getLongPreference(String key, long defaultValue) {
        if (preferences == null) {
            init();
        }

        String s = getPreference(key);
        return StringUtils.isBlank(s) ? defaultValue : Long.parseLong(s);
    }

    public static void setLongPreference(String key, long value) {
        if (preferences == null) {
            init();
        }

        setPreference(key, String.valueOf(value));
    }

    public static boolean getBooleanPreference(String key, boolean defaultValue) {
        if (preferences == null) {
            init();
        }

        String s = getPreference(key);
        return StringUtils.isBlank(s) ? defaultValue : Boolean.parseBoolean(s);
    }

    public static void setBooleanPreference(String key, boolean value) {
        if (preferences == null) {
            init();
        }

        setPreference(key, String.valueOf(value));
    }

    private static String replacePlaceHolder(String message, String[] params) {
        if (StringUtils.isBlank(message)) {
            return message;
        } else if (params != null && params.length != 0) {
            Map<String, String> map = new HashMap();
            Pattern p = Pattern.compile("\\{(\\d+)\\}");
            Matcher m = p.matcher(message);

            while(m.find()) {
                if (m.groupCount() >= 1) {
                    int index = Integer.parseInt(m.group(1));
                    if (index >= 0 && index < params.length) {
                        map.put(m.group(0), params[index]);
                    }
                }
            }

            if (map.isEmpty()) {
                return message;
            } else {
                Map.Entry entry;
                for(Iterator i$ = map.entrySet().iterator(); i$.hasNext(); message = message.replace((CharSequence)entry.getKey(), (CharSequence)entry.getValue())) {
                    entry = (Map.Entry)i$.next();
                }

                return message;
            }
        } else {
            return message;
        }
    }

    public static void main(String[] args) {
        String s = "thia is a {4} or a {1} {0} hahah";
        String[] params = new String[]{"AA", "BB", "CC"};
        Map<String, String> map = new HashMap();
        Pattern p = Pattern.compile("\\{(\\d+)\\}");
        Matcher m = p.matcher(s);

        while(m.find()) {
            if (m.groupCount() >= 1) {
                int index = Integer.parseInt(m.group(1));
                if (index >= 0 && index < params.length) {
                    map.put(m.group(0), params[index]);
                }
            }
        }

        Map.Entry entry;
        for(Iterator i$ = map.entrySet().iterator(); i$.hasNext(); s = s.replace((CharSequence)entry.getKey(), (CharSequence)entry.getValue())) {
            entry = (Map.Entry)i$.next();
        }

        System.out.println(s);
    }
}