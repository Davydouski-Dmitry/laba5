package com.davydouski;

public abstract class Electronics {

    private String nameElectro;

    //конструктор
    public Electronics(String nameElectronics) {
        this.nameElectro = nameElectronics;
    }


    public String getName() {
        return nameElectro;
    }

    public abstract void show();
}
