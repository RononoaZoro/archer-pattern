package com.luo.original;

/**
 * 模拟器v1
 *
 * @author luoxuzheng
 * @create 2019-09-20 7:56
 **/
public class DuckSimulator {

    public static void main(String[] args) {
        Quackable duckCall = new DuckCall();
        Quackable mallardDuck = new MallardDuck();
        Quackable redHeadDuck = new RedHeadDuck();
        Quackable rubberDuck = new RubberDuck();

        simulate(duckCall);
        simulate(mallardDuck);
        simulate(redHeadDuck);
        simulate(rubberDuck);
    }

    private static void simulate(Quackable duck) {
        duck.quack();
    }


}
