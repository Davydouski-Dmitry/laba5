package com.davydouski;

public class TV extends Electronics implements Printable,Comparable<TV>{

    private String model;
    private int price;

    //изменили конструктор
    public TV(String name,String modelTv,int priceTV) {
        super(name);
        this.model = modelTv;
        this.price = priceTV;
    }


    public void show() {
        System.out.println(model + " - модель");
    }

    @Override
    public void Print() {
        System.out.println("Телевизор" + super.getNameElectro() + " модели: "+ model);
    }

    @Override
    public int compareTo(TV p) {
        if(this.price == p.price)
            return 0;
        else
            return this.price > p.price ? 1 : -1;
    }
}
