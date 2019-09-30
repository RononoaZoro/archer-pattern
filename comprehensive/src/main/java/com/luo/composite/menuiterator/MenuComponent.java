package com.luo.composite.menuiterator;

import java.util.Iterator;

/**
 * @author luoxuzheng
 * @create 2019-09-30 10:39
 **/
public abstract class MenuComponent {

    /**
     * 增加
     * @param menuComponent
     */
    public void add(MenuComponent menuComponent) {

        throw new UnsupportedOperationException();
    }

    /**
     * 删除
     * @param menuComponent
     */
    public void remove(MenuComponent menuComponent) {

        throw new UnsupportedOperationException();
    }

    /**
     * 获取子节点
     * @param i
     * @return
     */
    public MenuComponent getChild(int i) {

        throw new UnsupportedOperationException();
    }

    /**
     * 获取名称
     * @return
     */
    public String getName() {

        throw new UnsupportedOperationException();
    }

    /**
     * 获取描述
     * @return
     */
    public String getDescription() {

        throw new UnsupportedOperationException();
    }

    /**
     * 获取价格
     * @return
     */
    public double getPrice() {

        throw new UnsupportedOperationException();
    }

    /**
     * 是否是蔬菜
     * @return
     */
    public boolean isVegetarian() {

        throw new UnsupportedOperationException();
    }

    /**
     * 创建迭代器
     * @return
     */
    public abstract Iterator<MenuComponent> createIterator();

    /**
     * 打印
     */
    public void print() {

        throw new UnsupportedOperationException();
    }
}
