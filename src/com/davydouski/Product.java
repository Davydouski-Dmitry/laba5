package com.davydouski;

//Разработать класс для хранения информации о товарах: Наименование, производитель, количество_единиц, цена


public class Product {

    private String name;            //Наименование
    private String manufacturer;    //производитель
    private int numberUnits;        //количество_единиц
    private int price;              //цена


    private static int counter;//счётчик объектов
    //инициализатор
    static{
        counter=0;
    }

    public static int getCounter() {
        return counter;
    }


    //конструктор класса товары
    public Product(String name, String manufacturer, int numberUnits, int price) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.numberUnits = numberUnits;
        this.price = price;
        counter++;
    }
//еще один конструктор
    public Product(String name, String manufacturer, int numberUnits) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.numberUnits = numberUnits;
    }


    //геттеры и сеттеры для класса товары
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getNumberUnits() {
        return numberUnits;
    }

    public void setNumberUnits(int numberUnits) {
        this.numberUnits = numberUnits;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }








}
