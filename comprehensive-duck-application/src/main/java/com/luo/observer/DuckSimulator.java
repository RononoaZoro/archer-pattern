package com.luo.observer;


/**
 * 模拟器v6
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
        CountingDuckFactory countingDuckFactory = new CountingDuckFactory();

//        Quackable duckCall = countingDuckFactory.createDuckCall();
//        Quackable mallardDuck = countingDuckFactory.createMallardDuck();
//        Quackable redHeadDuck = countingDuckFactory.createRedHeadDuck();
//        Quackable rubberDuck = countingDuckFactory.createRubberDuck();
//
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
//
//        flockOfDucks.add(duckCall);
//        flockOfDucks.add(mallardDuck);
//        flockOfDucks.add(redHeadDuck);
//        flockOfDucks.add(rubberDuck);
//        flockOfDucks.add(gooseDuck);


        FlockQuackables flockOfMallardDucks = new FlockQuackables();

        Quackable mallardDuckOne = countingDuckFactory.createMallardDuck();
        Quackable mallardDuckTwo = countingDuckFactory.createMallardDuck();
        Quackable mallardDuckThree = countingDuckFactory.createMallardDuck();
        Quackable mallardDuckFour = countingDuckFactory.createMallardDuck();

        flockOfMallardDucks.add(mallardDuckOne);
        flockOfMallardDucks.add(mallardDuckTwo);
        flockOfMallardDucks.add(mallardDuckThree);
        flockOfMallardDucks.add(mallardDuckFour);

        Observer quackOlogist = new QuackOlogist();

        //测试一
//        flockOfDucks.add(flockOfMallardDucks);
//
//        System.out.println("\nDuck Simulator : Whole Flock Simulation Whth Observer");
//        flockOfDucks.registerObserver(quackOlogist);
//        simulate(flockOfDucks);


        //测试二
        System.out.println("\nDuck Simulator : Mallard Flock Simulation Whth Observer");
        flockOfMallardDucks.registerObserver(quackOlogist);
        simulate(flockOfMallardDucks);

        System.out.printf("The ducks quacked %d times", QuackCounterDecorator.getNumberOfQuacks());
    }

    private void simulate(Quackable duck) {
        duck.quack();
    }


}
