package com.luo.command.simpleremoteWL;

/**
 * 命令发出者
 *
 * @author luoxuzheng
 * @create 2019-09-15 21:56
 **/
public class SimpleRemoteControl {
    private Command slot;

    public SimpleRemoteControl() {
    }

    public void setCommand(Command slot) {
        this.slot = slot;
    }

    public void buttonWasPressed() {
        slot.execute();
    }
}
