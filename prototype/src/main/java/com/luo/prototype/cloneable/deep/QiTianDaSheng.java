package com.luo.prototype.cloneable.deep;

import java.io.*;
import java.util.Date;

/**
 * @author luoxuzheng
 * @create 2019-08-12 11:24
 **/
public class QiTianDaSheng extends Monkey implements Serializable,Cloneable {
    private static final long serialVersionUID = -6692944896629258456L;

    JinGuBang jinGuBang;

    public  QiTianDaSheng(){
        //只是初始化
        this.birthday = new Date();
        this.jinGuBang = new JinGuBang();
    }

    @Override
    protected QiTianDaSheng clone() throws CloneNotSupportedException {
        return (QiTianDaSheng)this.deepClone();
    }

    private Object deepClone() {
        QiTianDaSheng copy = null;
        //写到文件中需要
//        FileOutputStream fos = new FileOutputStream();

        //只是写到流中
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);

            copy = (QiTianDaSheng)ois.readObject();
            copy.birthday = new Date();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return copy;
    }


    public QiTianDaSheng copy(QiTianDaSheng target){

        QiTianDaSheng qiTianDaSheng = new QiTianDaSheng();
        qiTianDaSheng.height = target.height;
        qiTianDaSheng.weight = target.height;

        qiTianDaSheng.jinGuBang = new JinGuBang();
        qiTianDaSheng.jinGuBang.h = target.jinGuBang.h;
        qiTianDaSheng.jinGuBang.d = target.jinGuBang.d;

        qiTianDaSheng.birthday = new Date();
        return  qiTianDaSheng;
    }
}
