package com.gorani.springplayground.java.singleton;

public class EagerInitSingleton {

    public final static EagerInitSingleton INSTANCE = new EagerInitSingleton();

    private EagerInitSingleton() {
        System.out.println("eager init singleton start");
    }

    public static EagerInitSingleton getInstance() {
        System.out.println("get singleton");
        return INSTANCE;
    }
}
