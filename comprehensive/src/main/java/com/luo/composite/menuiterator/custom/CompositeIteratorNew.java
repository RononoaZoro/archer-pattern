package com.luo.composite.menuiterator.custom;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author luoxuzheng
 * @create 2019-09-30 12:18
 **/
public class CompositeIteratorNew implements Iterator<MenuComponentNew> {

    Stack<Iterator<MenuComponentNew>> stack = new Stack<Iterator<MenuComponentNew>>();

    public CompositeIteratorNew(Iterator<MenuComponentNew> iterator) {
        stack.push(iterator);
    }


    @Override
    public boolean hasNext() {
        if (stack.empty()) return false;

        Iterator<MenuComponentNew> iterator = stack.peek();

        if (iterator.hasNext()) return true;

        stack.pop();
        return hasNext();
    }

    @Override
    public MenuComponentNew next() {

        if(!hasNext()) return null;

        Iterator<MenuComponentNew> iterator = stack.peek();
        MenuComponentNew component = iterator.next();

        if(component instanceof MenuNew) stack.push(component.createIterator());

        return component;
    }
}
