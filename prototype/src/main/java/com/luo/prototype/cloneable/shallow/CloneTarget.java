package com.luo.prototype.cloneable.shallow;

/**
 * @author luoxuzheng
 * @create 2019-08-12 10:53
 **/
public class CloneTarget extends Prototype {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "CloneTarget{" +
                "name='" + name + '\'' +
                ", target=" + target +
                '}';
    }
}
