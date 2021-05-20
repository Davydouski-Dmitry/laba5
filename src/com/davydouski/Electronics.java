package com.davydouski;

public abstract class Electronics {

    private String nameElectro;

    //геттер
    public String getNameElectro() {
        return nameElectro;
    }

    //конструктор
    public Electronics(String nameElectronics) {
        this.nameElectro = nameElectronics;
    }

    public abstract void show();

}
