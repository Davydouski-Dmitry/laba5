package com.davydouski;


import java.io.Serializable;
import java.util.Date;


public class Smartphone extends Electronics implements Printable,Comparable {


    public Smartphone(String name) {
        super(name);
    }

    @Override
    public void show() {
        System.out.println("Smartphone - " + super.getNameElectro());
    }

    @Override
    public void Print() {
        System.out.println("Объект класса Smartphone ");
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
