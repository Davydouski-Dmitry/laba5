package com.davydouski;

public class Smartphone extends Electronics{


    public Smartphone(String name) {
        super(name);
    }

    @Override
    public void show() {
        System.out.println("Smartphone");
    }
}
