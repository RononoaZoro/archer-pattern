package com.luo.observer;

public class CountingDuckFactory extends AbstractDuckFactory {

	@Override
	public Quackable createMallardDuck() {
		return new QuackCounterDecorator(new MallardDuck());
	}

	@Override
	Quackable createRedHeadDuck() {
		return new QuackCounterDecorator(new RedHeadDuck());
	}


	@Override
	public Quackable createDuckCall() {
		return new QuackCounterDecorator(new DuckCall());
	}

	@Override
	public Quackable createRubberDuck() {
		return new QuackCounterDecorator(new RubberDuck());
	}

//	@Override
//	Quackable createGooseAdapter() {
//		return null;
//	}
}
