package com.luo.prototype.util;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * VO DTO DOMAIN ENTITY转换工具类
 * @author luoxuzheng
 * @create 2019-08-13 12:25
 *
 *
 * 总结
 * 一个看似简单的BeanUtils工具类，其实里面包含的Java基础的知识点非常多，
 * 包括类型信息、反射、线程安全、引用类型、类加载器等。
 * Spring的BeanUtils的实现里使用了ConcurrentHashMap作为缓存，
 * 每次去获取PropertyDescriptor时，可以直接去缓存里面获取，而不必每次都去调用native方法，所以Spring的BeanUtils的性能还是很不错的。
 *
 *
 **/
public class BeanUtils {
    private static final int DATEFORMAT_10LENGTH = 10;
    private static Map<String, Map> beanMap = Collections.synchronizedMap(new HashMap());
    private static Map<String, Map> fieldDescriptorMap = Collections.synchronizedMap(new HashMap());
    private static String iscache = SystemGlobals.getPreference("cache.bean.field");

    public BeanUtils() {
    }

    public static void copyProperties(Object target, Object source) {
        Map<String, Field> sourceFields = getFields(source);
        Map<String, Field> targetFields = getFields(target);
        if (sourceFields != null && !sourceFields.isEmpty() && targetFields != null && !targetFields.isEmpty()) {
            Iterator i$ = sourceFields.entrySet().iterator();

            while (i$.hasNext()) {
                Map.Entry<String, Field> entry = (Map.Entry) i$.next();
                String key = (String) entry.getKey();
                Field fd = (Field) entry.getValue();
                Field targetField = (Field) targetFields.get(key);
                if (targetField != null) {
                    try {
                        copyValue(target, targetField, source, fd);
                    } catch (ParseException var10) {
                        var10.printStackTrace();
                    }
                }
            }

        }
    }

    public static void copyValue(Object targetObj, Field targetField, Object sourceObj, Field sourceField) throws ParseException {
        try {
            Class targetClass = targetField.getType();
            Class sourceClass = sourceField.getType();
            String targetClassName = targetClass.getName();
            String sourceClassName = sourceClass.getName();
            sourceField.setAccessible(true);
            targetField.setAccessible(true);
            Object sourceValue = sourceField.get(sourceObj);
            if (targetClass.equals(sourceClass)) {
                targetField.set(targetObj, sourceValue);
                return;
            }

            if (sourceValue == null) {
                if (isNumber(targetClass, false)) {
                    targetField.set(targetObj, 0);
                } else if ("boolean".equals(targetClassName)) {
                    targetField.set(targetObj, false);
                } else {
                    targetField.set(targetObj, (Object) null);
                }

                return;
            }

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
            String s = sourceValue.toString();
            if ("java.lang.String".equals(targetClassName)) {
                if (Date.class.isAssignableFrom(sourceClass)) {
                    targetField.set(targetObj, df.format((Date) sourceValue));
                } else {
                    targetField.set(targetObj, sourceValue.toString());
                }
            } else if (!"int".equals(targetClassName) && !"java.lang.Integer".equals(targetClassName)) {
                if (!"byte".equals(targetClassName) && !"java.lang.Byte".equals(targetClassName)) {
                    if (!"short".equals(targetClassName) && !"java.lang.Short".equals(targetClassName)) {
                        if (!"long".equals(targetClassName) && !"java.lang.long".equals(targetClassName)) {
                            if (!"float".equals(targetClassName) && !"java.lang.Float".equals(targetClassName)) {
                                if (!"double".equals(targetClassName) && !"java.lang.Double".equals(targetClassName)) {
                                    if (!"boolean".equals(targetClassName) && !"java.lang.Boolean".equals(targetClassName)) {
                                        if (targetClass.isAssignableFrom(Date.class)) {
                                            long l = 0L;
                                            if (sourceClass.isAssignableFrom(Date.class)) {
                                                l = ((Date) sourceValue).getTime();
                                            } else if ("java.lang.String".equals(sourceClassName)) {
                                                if (s.length() >= 19) {
                                                    l = df.parse(s).getTime();
                                                } else {
                                                    l = df2.parse(s).getTime();
                                                }
                                            }

                                            if (l > 0L) {
                                                Constructor c = targetClass.getConstructor(Long.TYPE);
                                                if (c != null) {
                                                    targetField.set(targetObj, c.newInstance(l));
                                                }
                                            }
                                        }
                                    } else if ("java.lang.Boolean".equals(sourceClassName) || "boolean".equals(sourceClassName) || "java.lang.String".equals(sourceClassName)) {
                                        targetField.set(targetObj, Boolean.parseBoolean(s));
                                    }
                                } else if (isNumber(sourceClass, true) || "java.lang.String".equals(sourceClassName)) {
                                    targetField.set(targetObj, Double.parseDouble(s));
                                }
                            } else if (isNumber(sourceClass, true) || "java.lang.String".equals(sourceClassName)) {
                                targetField.set(targetObj, Float.parseFloat(s));
                            }
                        } else if (isNumber(sourceClass, true) || "java.lang.String".equals(sourceClassName)) {
                            targetField.set(targetObj, Long.parseLong(getPointPre(s)));
                        }
                    } else if (isNumber(sourceClass, true) || "java.lang.String".equals(sourceClassName)) {
                        targetField.set(targetObj, Short.parseShort(getPointPre(s)));
                    }
                } else if (isNumber(sourceClass, true) || "java.lang.String".equals(sourceClassName)) {
                    targetField.set(targetObj, Byte.parseByte(getPointPre(s)));
                }
            } else if (isNumber(sourceClass, true) || "java.lang.String".equals(sourceClassName)) {
                targetField.set(targetObj, Integer.parseInt(getPointPre(s)));
            }
        } catch (Exception var15) {
        }

    }

    private static String getPointPre(String str) {
        int index = str.indexOf(".");
        if (index != -1) {
            str = str.substring(0, index);
        }

        return str;
    }

    public static Map<String, Field> getFields(Object obj) {
        Class c = obj.getClass();
        Map<String, Field> fs = null;
        String className = c.getName();
        fs = (Map) beanMap.get(className);
        if (fs == null) {
            fs = new HashMap();

            for (Field[] fields = null; !c.getName().equals(Object.class.getName()); c = c.getSuperclass()) {
                fields = c.getDeclaredFields();
                Field[] arr$ = fields;
                int len$ = fields.length;

                for (int i$ = 0; i$ < len$; ++i$) {
                    Field field = arr$[i$];
                    if (!((Map) fs).containsKey(field.getName())) {
                        ((Map) fs).put(field.getName(), field);
                    }
                }
            }

            if ("true".equals(iscache)) {
                beanMap.put(className, fs);
            }
        }

        return (Map) fs;
    }

    public static boolean isList(Class clazz) {
        if ("java.util.List".equals(clazz.getName())) {
            return true;
        } else {
            Class[] interfaces = clazz.getInterfaces();
            if (interfaces != null && interfaces.length != 0) {
                Class[] arr$ = interfaces;
                int len$ = interfaces.length;

                for (int i$ = 0; i$ < len$; ++i$) {
                    Class c = arr$[i$];
                    if ("java.util.List".equals(c.getName())) {
                        return true;
                    }
                }

                return false;
            } else {
                return false;
            }
        }
    }

    public static boolean isMap(Class clazz) {
        if ("java.util.Map".equals(clazz.getName())) {
            return true;
        } else {
            Class[] interfaces = clazz.getInterfaces();
            if (interfaces != null && interfaces.length != 0) {
                Class[] arr$ = interfaces;
                int len$ = interfaces.length;

                for (int i$ = 0; i$ < len$; ++i$) {
                    Class c = arr$[i$];
                    if ("java.util.Map".equals(c.getName())) {
                        return true;
                    }
                }

                return false;
            } else {
                return false;
            }
        }
    }

    public static boolean isArray(Class clazz) {
        String className = clazz.getName();
        return className.startsWith("[");
    }

    public static boolean isPrimitive(Class clazz) {
        String className = clazz.getName();
        if (!"int".equals(className) && !"java.lang.Integer".equals(className)) {
            if ("java.lang.String".equals(className)) {
                return true;
            } else if (!"long".equals(className) && !"java.lang.Long".equals(className)) {
                if (!"float".equals(className) && !"java.lang.Float".equals(className)) {
                    if (Date.class.isAssignableFrom(clazz)) {
                        return true;
                    } else if (!"byte".equals(className) && !"java.lang.Byte".equals(className)) {
                        if (!"short".equals(className) && !"java.lang.Short".equals(className)) {
                            if (!"double".equals(className) && !"java.lang.Double".equals(className)) {
                                if (!"char".equals(className) && !"java.lang.Character".equals(className)) {
                                    if (!"boolean".equals(className) && !"java.lang.Boolean".equals(className)) {
                                        if ("[B".equals(className)) {
                                            return true;
                                        } else {
                                            return BigDecimal.class.isAssignableFrom(clazz);
                                        }
                                    } else {
                                        return true;
                                    }
                                } else {
                                    return true;
                                }
                            } else {
                                return true;
                            }
                        } else {
                            return true;
                        }
                    } else {
                        return true;
                    }
                } else {
                    return true;
                }
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    public static boolean isNumber(Class c, boolean wrapper) {
        String className = c.getName();
        if (!"int".equals(className) && !"long".equals(className) && !"float".equals(className) && !"double".equals(className) && !"byte".equals(className) && !"short".equals(className)) {
            return wrapper && ("java.lang.Integer".equals(className) || "java.lang.Long".equals(className) || "java.lang.Float".equals(className) || "java.lang.Double".equals(className) || "java.lang.Byte".equals(className) || "java.lang.Short".equals(className));
        } else {
            return true;
        }
    }

//    public static <T> T convert(Object value, Class<T> clazz) {
//        String className = clazz.getName();
//        if (value == null) {
//            if ("int".equals(className)) {
//                return new Integer(0);
//            } else if ("float".equals(className)) {
//                return new Float(0.0F);
//            } else if ("long".equals(className)) {
//                return new Long(0L);
//            } else if ("double".equals(className)) {
//                return new Double(0.0D);
//            } else if ("byte".equals(className)) {
//                return new Byte((byte) 0);
//            } else if ("short".equals(className)) {
//                return new Short((short) 0);
//            } else if ("char".equals(className)) {
//                char c = 0;
//                return new Character(c);
//            } else {
//                return "boolean".equals(className) ? Boolean.FALSE : null;
//            }
//        } else {
//            String valueClass = value.getClass().getName();
//            if (className.equals(valueClass)) {
//                return value;
//            } else {
//                try {
//                    if ("java.lang.String".equals(className)) {
//                        return value.toString();
//                    } else {
//                        String s;
//                        if (!"int".equals(className) && !"java.lang.Integer".equals(className)) {
//                            if (!"float".equals(className) && !"java.lang.Float".equals(className)) {
//                                if (!"double".equals(className) && !"java.lang.Double".equals(className)) {
//                                    if (!"long".equals(className) && !"java.lang.Long".equals(className)) {
//                                        if (!"short".equals(className) && !"java.lang.Short".equals(className)) {
//                                            if (!"byte".equals(className) && !"java.lang.Byte".equals(className)) {
//                                                if ("java.lang.BigDecimal".equals(className)) {
//                                                    if ("java.lang.Short".equals(valueClass)) {
//                                                        return new BigDecimal((Short) value);
//                                                    } else if ("java.lang.Long".equals(valueClass)) {
//                                                        return new BigDecimal((Long) value);
//                                                    } else if ("java.lang.Integer".equals(valueClass)) {
//                                                        return new BigDecimal((Integer) value);
//                                                    } else if ("java.lang.Double".equals(valueClass)) {
//                                                        return new BigDecimal((Double) value);
//                                                    } else if ("java.lang.Float".equals(valueClass)) {
//                                                        return new BigDecimal((double) (Float) value);
//                                                    } else if ("java.lang.Byte".equals(valueClass)) {
//                                                        return new BigDecimal((Byte) value);
//                                                    } else if ("java.lang.String".equals(valueClass)) {
//                                                        s = (String) value;
//                                                        if (StringUtils.isNumeric(s)) {
//                                                            return new BigDecimal(s);
//                                                        } else {
//                                                            throw new ClassCastException("cannot convert " + valueClass + " to BigDecimal");
//                                                        }
//                                                    } else {
//                                                        throw new ClassCastException("cannot convert " + valueClass + " to BigDecimal");
//                                                    }
//                                                } else if (!"boolean".equals(className) && !"java.lang.Boolean".equals(className)) {
//                                                    if (!Date.class.isAssignableFrom(clazz)) {
//                                                        throw new ClassCastException("Cannot convert " + valueClass + " to " + className);
//                                                    } else if (Date.class.isAssignableFrom(value.getClass())) {
//                                                        long time = ((Date) value).getTime();
//                                                        Object o = clazz.getConstructor(Long.TYPE).newInstance(time);
//                                                        return o;
//                                                    } else if ("java.lang.String".equals(valueClass)) {
//                                                        s = ((String) value).trim();
//                                                        SimpleDateFormat df = null;
//                                                        if (s.length() == 10) {
//                                                            df = new SimpleDateFormat("yyyy-MM-dd");
//                                                        } else if (s.length() == 16) {
//                                                            df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//                                                        } else if (s.length() == 19) {
//                                                            df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                                                        }
//
//                                                        if (df != null) {
//                                                            return df.parse(s);
//                                                        } else {
//                                                            throw new ClassCastException("Cannot convert " + valueClass + " to " + className);
//                                                        }
//                                                    } else {
//                                                        throw new ClassCastException("Cannot convert " + valueClass + " to " + className);
//                                                    }
//                                                } else if ("java.lang.Boolean".equals(valueClass)) {
//                                                    return value;
//                                                } else if ("java.lang.String".equals(valueClass)) {
//                                                    s = (String) value;
//                                                    if ("true".equalsIgnoreCase(s)) {
//                                                        return Boolean.TRUE;
//                                                    } else {
//                                                        return Boolean.FALSE;
//                                                    }
//                                                } else {
//                                                    throw new ClassCastException("cannot convert " + valueClass + " to boolean");
//                                                }
//                                            } else if ("java.lang.Byte".equals(valueClass)) {
//                                                return value;
//                                            } else if ("java.lang.Short".equals(valueClass)) {
//                                                return new Byte(((Short) value).byteValue());
//                                            } else if ("java.lang.Long".equals(valueClass)) {
//                                                return new Byte(((Long) value).byteValue());
//                                            } else if ("java.lang.Integer".equals(valueClass)) {
//                                                return new Byte(((Integer) value).byteValue());
//                                            } else if ("java.lang.Double".equals(valueClass)) {
//                                                return new Byte(((Double) value).byteValue());
//                                            } else if ("java.lang.Float".equals(valueClass)) {
//                                                return new Byte(((Float) value).byteValue());
//                                            } else if ("java.lang.BigDecimal".equals(valueClass)) {
//                                                return new Byte(((BigDecimal) value).byteValue());
//                                            } else if ("java.lang.String".equals(valueClass)) {
//                                                s = (String) value;
//                                                if (StringUtils.isNumeric(s)) {
//                                                    return new Byte(s);
//                                                } else {
//                                                    throw new ClassCastException("cannot convert " + valueClass + " to byte");
//                                                }
//                                            } else {
//                                                throw new ClassCastException("cannot convert " + valueClass + " to byte");
//                                            }
//                                        } else if ("java.lang.Byte".equals(valueClass)) {
//                                            return new Short(((Byte) value).shortValue());
//                                        } else if ("java.lang.Short".equals(valueClass)) {
//                                            return value;
//                                        } else if ("java.lang.Integer".equals(valueClass)) {
//                                            return new Short(((Integer) value).shortValue());
//                                        } else if ("java.lang.Long".equals(valueClass)) {
//                                            return new Short(((Long) value).shortValue());
//                                        } else if ("java.lang.Float".equals(valueClass)) {
//                                            return new Short(((Float) value).shortValue());
//                                        } else if ("java.lang.Double".equals(valueClass)) {
//                                            return new Short(((Double) value).shortValue());
//                                        } else if ("java.lang.BigDecimal".equals(valueClass)) {
//                                            return new Short(((BigDecimal) value).shortValue());
//                                        } else if ("java.lang.String".equals(valueClass)) {
//                                            s = (String) value;
//                                            if (StringUtils.isNumeric(s)) {
//                                                return new Short(s);
//                                            } else {
//                                                throw new ClassCastException("cannot convert " + valueClass + " to short");
//                                            }
//                                        } else {
//                                            throw new ClassCastException("cannot convert " + valueClass + " to short");
//                                        }
//                                    } else if ("java.lang.Byte".equals(valueClass)) {
//                                        return new Long(((Byte) value).longValue());
//                                    } else if ("java.lang.Short".equals(valueClass)) {
//                                        return new Long(((Short) value).longValue());
//                                    } else if ("java.lang.Integer".equals(valueClass)) {
//                                        return new Long(((Integer) value).longValue());
//                                    } else if ("java.lang.Long".equals(valueClass)) {
//                                        return value;
//                                    } else if ("java.lang.Float".equals(valueClass)) {
//                                        return new Long(((Float) value).longValue());
//                                    } else if ("java.lang.Double".equals(valueClass)) {
//                                        return new Long(((Double) value).longValue());
//                                    } else if ("java.lang.BigDecimal".equals(valueClass)) {
//                                        return new Long(((BigDecimal) value).longValue());
//                                    } else if ("java.lang.String".equals(valueClass)) {
//                                        s = (String) value;
//                                        if (StringUtils.isNumeric(s)) {
//                                            return new Long(s);
//                                        } else {
//                                            throw new ClassCastException("cannot convert " + valueClass + " to long");
//                                        }
//                                    } else {
//                                        throw new ClassCastException("cannot convert " + valueClass + " to long");
//                                    }
//                                } else if ("java.lang.Byte".equals(valueClass)) {
//                                    return new Double(((Byte) value).doubleValue());
//                                } else if ("java.lang.Short".equals(valueClass)) {
//                                    return new Double(((Short) value).doubleValue());
//                                } else if ("java.lang.Integer".equals(valueClass)) {
//                                    return new Double(((Integer) value).doubleValue());
//                                } else if ("java.lang.Long".equals(valueClass)) {
//                                    return new Double(((Long) value).doubleValue());
//                                } else if ("java.lang.Float".equals(valueClass)) {
//                                    return new Double(((Float) value).doubleValue());
//                                } else if ("java.lang.Double".equals(valueClass)) {
//                                    return value;
//                                } else if ("java.lang.BigDecimal".equals(valueClass)) {
//                                    return new Double(((BigDecimal) value).doubleValue());
//                                } else if ("java.lang.String".equals(valueClass)) {
//                                    s = (String) value;
//                                    if (StringUtils.isNumeric(s)) {
//                                        return new Double(s);
//                                    } else {
//                                        throw new ClassCastException("cannot convert " + valueClass + " to double");
//                                    }
//                                } else {
//                                    throw new ClassCastException("cannot convert " + valueClass + " to double");
//                                }
//                            } else if ("java.lang.Byte".equals(valueClass)) {
//                                return new Float(((Byte) value).floatValue());
//                            } else if ("java.lang.Short".equals(valueClass)) {
//                                return new Float(((Short) value).floatValue());
//                            } else if ("java.lang.Integer".equals(valueClass)) {
//                                return new Float(((Integer) value).floatValue());
//                            } else if ("java.lang.Long".equals(valueClass)) {
//                                return new Float(((Long) value).floatValue());
//                            } else if ("java.lang.Float".equals(valueClass)) {
//                                return value;
//                            } else if ("java.lang.Double".equals(valueClass)) {
//                                return new Float(((Double) value).floatValue());
//                            } else if ("java.lang.BigDecimal".equals(valueClass)) {
//                                return new Float(((BigDecimal) value).floatValue());
//                            } else if ("java.lang.String".equals(valueClass)) {
//                                s = (String) value;
//                                if (StringUtils.isNumeric(s)) {
//                                    return new Float(s);
//                                } else {
//                                    throw new ClassCastException("cannot convert " + valueClass + " to float");
//                                }
//                            } else {
//                                throw new ClassCastException("cannot convert " + valueClass + " to float");
//                            }
//                        } else if ("java.lang.Byte".equals(valueClass)) {
//                            return new Integer(((Byte) value).intValue());
//                        } else if ("java.lang.Short".equals(valueClass)) {
//                            return new Integer(((Short) value).intValue());
//                        } else if ("java.lang.Integer".equals(valueClass)) {
//                            return value;
//                        } else if ("java.lang.Long".equals(valueClass)) {
//                            return new Integer(((Long) value).intValue());
//                        } else if ("java.lang.Float".equals(valueClass)) {
//                            return new Integer(((Float) value).intValue());
//                        } else if ("java.lang.Double".equals(valueClass)) {
//                            return new Integer(((Double) value).intValue());
//                        } else if ("java.lang.BigDecimal".equals(valueClass)) {
//                            return new Integer(((BigDecimal) value).intValue());
//                        } else if ("java.lang.String".equals(valueClass)) {
//                            s = (String) value;
//                            if (StringUtils.isNumeric(s)) {
//                                return new Integer(s);
//                            } else {
//                                throw new ClassCastException("cannot convert " + valueClass + " to int");
//                            }
//                        } else {
//                            throw new ClassCastException("cannot convert " + valueClass + " to int");
//                        }
//                    }
//                } catch (ClassCastException var7) {
//                    var7.printStackTrace();
//                    throw var7;
//                } catch (Exception var8) {
//                    var8.printStackTrace();
//                    throw new ClassCastException(var8.getMessage());
//                }
//            }
//        }
//    }

    public static Method getMethod(Class clazz, String methodName, Class[] parameterType, Class returnClass) {
        try {
            Method method = clazz.getMethod(methodName, parameterType);
            if (method == null) {
                return null;
            } else {
                Class r = method.getReturnType();
                return returnClass.isAssignableFrom(r) ? method : null;
            }
        } catch (Exception var6) {
            return null;
        }
    }
}
