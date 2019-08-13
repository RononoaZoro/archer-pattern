package com.luo.prototype.reflect.deep;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author luoxuzheng
 * @create 2019-08-13 12:33
 **/
public class Person {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) throws Exception {
//        Person test1 = new Person();
//        test1.setName("vvvv");
//        PropertyDescriptor pd = new PropertyDescriptor("name", test1.getClass());
//        Method setMethod = pd.getWriteMethod();  // 还有与Wirte方法对应的Read方法
//        setMethod.invoke(test1, "bbbbb");
//        System.out.print(test1);


//        List<?>[] lsa = new List<?>[10]; // OK, array of unbounded wildcard type.
//        Object o = lsa;
//        Object[] oa = (Object[]) o;
//        List<Integer> li = new ArrayList<Integer>();
//        li.add(new Integer(3));
//        oa[1] = li; // Correct.
//        Integer i = (Integer) lsa[1].get(0); // OK
//        System.out.println(i);

        List<String>[] lsa = new List[10];
        Object o = lsa;
        Object[] oa = (Object[]) o;
        List<String> li = new ArrayList<>();
        li.add(new String("3"));
        oa[1] = li; // Unsound, but passes run time store check
        String s = lsa[1].get(0); // Run-time error: ClassCastException.
        System.out.println(s);
    }



}
