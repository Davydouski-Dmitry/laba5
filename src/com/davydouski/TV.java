package com.davydouski;

public class TV extends Electronics{

    private String model;

    //изменили конструктор
    public TV(String name,String modelTv) {
        super(name);
        this.model = modelTv;
    }


    public void show() {
        System.out.println(super.getNameElectro() + "Телевизор модели: "+model);
    }

}
