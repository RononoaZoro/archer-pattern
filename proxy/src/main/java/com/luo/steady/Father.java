package com.luo.steady;

/**
 * @author luoxuzheng
 * @create 2019-08-12 12:29
 **/
public class Father {
    Person person;

    //没办法拓展，拿到目标对象的引用
    public Father(Person person){
        this.person = person;
    }

    public void findLove() {
        System.out.println("根据你的要求物色");
        this.person.findLove();
        System.out.println("双方父母是不是同意");
    }
}
