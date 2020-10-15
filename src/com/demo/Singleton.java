package com.demo;

public class Singleton {
    private static int value = 0;

    private Singleton() {

    }

    public static int getValue() {
        return value;
    }

    public static void incrementValue(int addedVal) {
        value += addedVal;
    }
}
