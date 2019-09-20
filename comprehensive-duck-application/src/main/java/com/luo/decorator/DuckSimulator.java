package com.luo.decorator;


/**
 * 模拟器v3
 *
 * @author luoxuzheng
 * @create 2019-09-20 7:56
 **/
public class DuckSimulator {

    public static void main(String[] args) {

        DuckSimulator duckSimulator = new DuckSimulator();
        duckSimulator.simulate();

    }

    private void simulate() {
        Quackable duckCall = new QuackCounterDecorator(new DuckCall());
        Quackable mallardDuck = new QuackCounterDecorator(new MallardDuck());
        Quackable redHeadDuck = new QuackCounterDecorator(new RedHeadDuck());
        Quackable rubberDuck = new QuackCounterDecorator(new RubberDuck());
        Quackable gooseDuck = new GooseAdapter(new Goose());

        simulate(duckCall);
        simulate(mallardDuck);
        simulate(redHeadDuck);
        simulate(rubberDuck);
        simulate(gooseDuck);

        System.out.printf("The ducks quacked " + QuackCounterDecorator.getNumberOfQuacks() + " times");
    }

    private void simulate(Quackable duck) {
        duck.quack();
    }


}
