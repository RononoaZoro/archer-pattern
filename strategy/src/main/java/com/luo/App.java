package com.luo;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        String[] objects = {"a", "2", "c"};
        String string = Arrays.toString(objects);
        string = string.replaceAll("\\[|\\]","");
        string = string.replaceAll("\\s",",");
        System.out.println(string);
    }
}
