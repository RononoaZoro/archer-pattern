package com.luo.factory;

/**
 * 鸭子的抽象工厂
 *
 * @author luoxuzheng
 * @create 2019-09-20 8:17
 **/
public class DuckFactory extends AbstractDuckFactory {

    @Override
    Quackable createDuckCall() {
        return new DuckCall();
    }

    @Override
    Quackable createMallardDuck() {
        return new MallardDuck();
    }

    @Override
    Quackable createRedHeadDuck() {
        return new RedHeadDuck();
    }

    @Override
    Quackable createRubberDuck() {
        return new RubberDuck();
    }

    @Override
    Quackable createGooseAdapter() {
        return new GooseAdapter(new Goose());
    }
}
