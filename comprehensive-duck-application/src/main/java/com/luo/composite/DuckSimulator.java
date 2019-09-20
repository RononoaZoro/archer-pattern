package com.luo.composite;


/**
 * 模拟器v5
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

        //牺牲了透明性，得到了安全性，调用add()时，必须事先确定是FlockQuackables类型
        FlockQuackables flockOfDucks = new FlockQuackables();


//        Quackable flockOfDucks = new FlockQuackables();
//
//        if(flockOfDucks instanceof FlockQuackables){
//            FlockQuackables flockOfDucksNew = (FlockQuackables) flockOfDucks;
//            flockOfDucksNew.add(duckCall);
//            flockOfDucksNew.add(mallardDuck);
//            flockOfDucksNew.add(redHeadDuck);
//            flockOfDucksNew.add(rubberDuck);
//            flockOfDucksNew.add(gooseDuck);
//        }

        flockOfDucks.add(duckCall);
        flockOfDucks.add(mallardDuck);
        flockOfDucks.add(redHeadDuck);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(gooseDuck);


        FlockQuackables flockOfMallardDucks = new FlockQuackables();

        Quackable mallardDuckOne = new QuackCounterDecorator(duckFactory.createMallardDuck());
        Quackable mallardDuckTwo = new QuackCounterDecorator(duckFactory.createMallardDuck());
        Quackable mallardDuckThree = new QuackCounterDecorator(duckFactory.createMallardDuck());
        Quackable mallardDuckFour = new QuackCounterDecorator(duckFactory.createMallardDuck());

        flockOfMallardDucks.add(mallardDuckOne);
        flockOfMallardDucks.add(mallardDuckTwo);
        flockOfMallardDucks.add(mallardDuckThree);
        flockOfMallardDucks.add(mallardDuckFour);

        flockOfDucks.add(flockOfMallardDucks);

        System.out.println("\nDuck Simulator : Whole Flock Simulation");
        simulate(flockOfDucks);

        System.out.println("\nDuck Simulator : Mallard Flock Simulation");
        simulate(flockOfMallardDucks);



//        simulate(duckCall);
//        simulate(mallardDuck);
//        simulate(redHeadDuck);
//        simulate(rubberDuck);
//        simulate(gooseDuck);
//
        System.out.printf("The ducks quacked %d times",QuackCounterDecorator.getNumberOfQuacks());
    }

    private void simulate(Quackable duck) {
        duck.quack();
    }


}
