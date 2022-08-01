package com.demo.algorithm.test;

import org.junit.Test;
import org.omg.CORBA.Object;

public class codeTest {



    @Test
    public void test(){
        String s = "0";
        s = "1";
        s = "2";
        System.out.println(s);
    }

    @Test
    public void clastest(){
        A a = new B();
        //System.out.println(a.a);
        a = new B();
    }

    @Test
    public void jst(){
        String s = new String();
        s = "aaa";
        System.out.println(s);
        s = "bbb";
        System.out.println(s);
    }

}

class A{
    public static String a = "a";

    static {
        System.out.println("a");
    }
    public A(){
        System.out.println("构造函数A");
    }
}

class B extends A{

    public static String c = "c";

    static {
        System.out.println("b");
    }

    public B(){
        System.out.println("构造函数B");
    }
}

