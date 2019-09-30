package com.luo.composite.menuiterator.custom;

import java.util.Iterator;

/**
 * @author luoxuzheng
 * @create 2019-09-30 10:39
 **/
public class NullIteratorNew implements Iterator<MenuComponentNew> {
   
	public MenuComponentNew next() {
		return null;
	}
  
	public boolean hasNext() {
		return false;
	}
   
	/*
	 * No longer needed as of Java 8
	 * 
	 * (non-Javadoc)
	 * @see java.util.Iterator#remove()
	 * 
	public void remove() {
		throw new UnsupportedOperationException();
	}
	*/
}
