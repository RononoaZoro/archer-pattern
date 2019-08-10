package com.luo.singleton.lazy;

/**
 * @author luoxuzheng
 * @create 2019-08-10 15:48
 **/

public class LazyTwo {

    private LazyTwo(){}

    private static LazyTwo lazy = null;

    public static synchronized LazyTwo getInstance(){

        if(lazy == null){
            lazy = new LazyTwo();
        }
        return lazy;

    }

}

