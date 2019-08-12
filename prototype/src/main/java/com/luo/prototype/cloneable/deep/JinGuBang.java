package com.luo.prototype.cloneable.deep;

import java.io.Serializable;

/**
 * @author luoxuzheng
 * @create 2019-08-12 11:24
 **/
public class JinGuBang implements Serializable {
    private static final long serialVersionUID = 5326371527530501026L;

    public float h = 100;
    public float d = 10;

    public void big(){
        this.d *= 2;
        this.h *= 2;
    }

    public void small(){
        this.d /= 2;
        this.h /= 2;
    }
}
