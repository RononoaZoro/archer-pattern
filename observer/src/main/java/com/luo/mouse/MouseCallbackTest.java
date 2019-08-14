package com.luo.mouse;

import com.luo.core.Event;

import java.lang.reflect.Method;

/**
 * 测试类
 *
 * @author luoxuzheng
 * @create 2019-08-14 20:47
 **/
public class MouseCallbackTest {

    public static void main(String[] args) {
        //观察者和被观察者之间没有必然联系
        //注册的时候，才产生联系


        //解耦


        try {
            MouseCallback callback = new MouseCallback();
            Method onClick = MouseCallback.class.getMethod("onClick", Event.class);


            //人为的调用鼠标的单击事件
            Mouse mouse = new Mouse();
            mouse.addListener(MouseEventType.ON_CLICK, callback,onClick);

            mouse.click();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
