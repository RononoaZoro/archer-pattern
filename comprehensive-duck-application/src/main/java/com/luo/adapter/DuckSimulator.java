package com.luo.adapter;


/**
 * 模拟器v2
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
        Quackable gooseDuck = new GooseAdapter(new Goose());

        simulate(duckCall);
        simulate(mallardDuck);
        simulate(redHeadDuck);
        simulate(rubberDuck);
        simulate(gooseDuck);
    }

    private static void simulate(Quackable duck) {
        duck.quack();
    }


}
