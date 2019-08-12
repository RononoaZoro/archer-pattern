package com.luo.prototype.cloneable.deep;

/**
 * 深复制测试‘
 *
 * @author luoxuzheng
 * @create 2019-08-12 11:37
 **/
public class DeepTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        QiTianDaSheng q = new QiTianDaSheng();
        QiTianDaSheng n = q.copy(q);
        System.out.println(q.jinGuBang == n.jinGuBang);

        QiTianDaSheng q1 = new QiTianDaSheng();
        QiTianDaSheng clone = q1.clone();
        System.out.println(q1.jinGuBang == clone.jinGuBang);


    }
}
