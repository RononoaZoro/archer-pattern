package com.luo;

/**
 * 优酷访问者
 *

 */
public class YoukuVisitor implements Visitor {

    @Override
    public void visit(Login login) {
        System.out.println("优酷访问者");
        login.accept(this);
    }
}
