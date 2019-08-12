package com.luo.prototype.cloneable.shallow;

/**
 * @author luoxuzheng
 * @create 2019-08-12 10:56
 **/
public class CloneTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneTarget cloneTarget = new CloneTarget();
        cloneTarget.name = "xiaoluoluo";
        CloneTarget target2 = new CloneTarget();
        target2.name = "tom";
        cloneTarget.target = target2;

        CloneTarget clone = (CloneTarget)cloneTarget.clone();

        System.out.println(clone);
        System.out.println(clone.target == cloneTarget.target);
    }
}
