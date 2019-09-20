package com.luo.factory;

/**
 * 鹅
 *
 * @author luoxuzheng
 * @create 2019-09-20 8:02
 **/
public class GooseAdapter implements Quackable {
    private Goose goose;

    public GooseAdapter(Goose goose) {
        this.goose = goose;
    }

    public void quack() {
        goose.honk();
    }
}
