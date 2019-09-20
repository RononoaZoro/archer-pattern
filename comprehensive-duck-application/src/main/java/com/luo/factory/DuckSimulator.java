package com.luo.factory;


/**
 * 模拟器v4
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
        AbstractDuckFactory duckFactory = new DuckFactory();

        Quackable duckCall = new QuackCounterDecorator(duckFactory.createDuckCall());
        Quackable mallardDuck = new QuackCounterDecorator(duckFactory.createMallardDuck());
        Quackable redHeadDuck = new QuackCounterDecorator(duckFactory.createRedHeadDuck());
        Quackable rubberDuck = new QuackCounterDecorator(duckFactory.createRubberDuck());
        Quackable gooseDuck = duckFactory.createGooseAdapter();

//        //或者
//        AbstractGooseFactory gooseFactory = new GooseFactory();
//        Quackable gooseDuck = gooseFactory.createGooseAdapter();

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
