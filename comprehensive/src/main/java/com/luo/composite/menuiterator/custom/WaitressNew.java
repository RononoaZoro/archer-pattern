package com.luo.composite.menuiterator.custom;

import java.util.Iterator;

/**
 * @author luoxuzheng
 * @create 2019-09-30 10:39
 **/
public class WaitressNew {
	MenuComponentNew allMenus;

	public WaitressNew(MenuComponentNew allMenus) {
		this.allMenus = allMenus;
	}

    /**
     * 打印全部用到的是内部实现的组合迭代器，不太符合单一职责
	 */
	public void printMenu() {
		allMenus.print();
	}

    /**
     * 用到外部组合迭代器，符合单一职责
	 */
	public void printVegetarianMenu() {
		Iterator<MenuComponentNew> iterator = allMenus.createIterator();

		System.out.println("\nVEGETARIAN MENU\n----");
		while (iterator.hasNext()) {
			MenuComponentNew menuComponent = iterator.next();
			try {
				if (menuComponent.isVegetarian()) {
					menuComponent.print();
				}
			} catch (UnsupportedOperationException e) {
				e.printStackTrace();
			}
		}
	}
}
