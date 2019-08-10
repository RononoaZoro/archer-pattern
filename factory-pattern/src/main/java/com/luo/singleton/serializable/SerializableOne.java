package com.luo.singleton.serializable;

import java.io.Serializable;

/**
 * 序列化单例
 *
 * @author luoxuzheng
 * @create 2019-08-10 17:50
 **/
//反序列化导致单例破坏
public class SerializableOne implements Serializable{
    private static final long serialVersionUID = -4890482959734766810L;
    //序列化就是说把内存中的状态通过转换成字节码的形式
    //从而转换一个IO流，写入到其他地方(可以是磁盘、网络IO)
    //内存中状态给永久保存下来了

    //反序列化
    //讲已经持久化的字节码内容，转换为IO流
    //通过IO流的读取，进而将读取的内容转换为Java对象
    //在转换过程中会重新创建对象new
    public final static SerializableOne serial = new SerializableOne();

    private SerializableOne(){}

    public static  SerializableOne getInstance(){
        return serial;
    }

    //jvm负责维护，当反序列化的时候，地址为同一个，从而保证是单例
    private  Object readResolve(){
        return  serial;
    }





}
