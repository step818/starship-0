package com.demo;

public class Test1 {

    public static void main(String[] args) {
        Singleton.incrementValue(5);
        System.out.println(Singleton.getValue());

        Test2 t2 = new Test2();
        t2.addInt(5);
        System.out.println(Singleton.getValue());
    }
}
