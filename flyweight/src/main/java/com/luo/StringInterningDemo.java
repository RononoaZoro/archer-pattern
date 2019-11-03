package com.luo;

/**
 * 享元设计模式
 */
public class StringInterningDemo {

    public static void main(String[] args) {

        String value = new String("Hello"); // 在 Heap
        String newValue = value.intern(); // 放置常亮池


    }
}
