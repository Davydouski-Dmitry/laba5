package com.davydouski;

public abstract class Electronics {

    private String nameElectro;//переменная

    //геттер
    public String getNameElectro() {
        return nameElectro;
    }

    //конструктор
    public Electronics(String nameElectronics) {
        this.nameElectro = nameElectronics;
    }

    //абстрактный метод
    public abstract void show();

}
