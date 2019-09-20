package com.luo.factory;

/**
 * @author luoxuzheng
 * @create 2019-09-20 8:24
 **/
public class GooseFactory extends AbstractGooseFactory {
    GooseAdapter createGooseAdapter() {
        return new GooseAdapter(new Goose());
    }
}
