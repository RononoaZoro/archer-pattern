package com.luo;

/**
 *
 * 中介者模式
 */
public class MediatorPatternTest {
    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }
}
