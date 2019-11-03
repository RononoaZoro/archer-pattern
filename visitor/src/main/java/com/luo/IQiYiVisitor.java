package com.luo;

/**
 * 爱奇艺访问者
 *
 */
public class IQiYiVisitor implements Visitor {

    @Override
    public void visit(Login login) {
        System.out.println("爱奇艺访问者");
        login.accept(this);
    }
}
