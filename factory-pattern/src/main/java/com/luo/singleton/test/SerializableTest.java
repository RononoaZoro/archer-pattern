package com.luo.singleton.test;

import com.luo.singleton.serializable.SerializableOne;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author luoxuzheng
 * @create 2019-08-10 18:04
 **/
public class SerializableTest {

    public static void main(String[] args) {
        SerializableOne s1 = null;
        SerializableOne s2 = SerializableOne.getInstance();

        FileOutputStream out = null;
        try{
            out = new FileOutputStream("SerializableOne.obj");
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(s2);
            oos.flush();
            oos.close();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            FileInputStream fis = new FileInputStream("SerializableOne.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (SerializableOne) ois.readObject();
            ois.close();
            fis.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s2);
    }
}
