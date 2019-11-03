package com.luo.listener;

/**
 * 事件对象
 * @author luoxuzheng
 * @create 2019-09-30 19:52
 **/
class Even{
    private Person person;

    public Even(Person person) {
        super();
        this.person = person;
    }

    public Even() {
        super();
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
