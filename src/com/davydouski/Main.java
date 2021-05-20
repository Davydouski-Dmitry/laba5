package com.davydouski;

//реализовать алгоритм работы с массивом данных объектов
//второй класс магазин, тут массив товаров

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Cтудент гр.Пв1-20ПО  Давыдовский Д.С.  Вариант4 ");

        Product[] products = new Product[5];//массив товаров обявляем и заполняем сами
        products[0] = new Product("ноутбук","hp",12,3600);
        products[1] = new Product("ноутбук","asus",2,2600);
        products[2] = new Product("ноутбук","lg",4,2100);
        products[3] = new Product("ноутбук","macbook",1,5600);
        products[4] = new Product("ноутбук","lenovo",9,1900);


        //  1.определить товары с максимальным количеством единиц;
        int numberMAX = numberUnitsMAX(products);
        System.out.println("Фирма ноутбуков с максимальным количеством единиц на складе в наличии:");
        showProduct(products[numberMAX]);


        //  2.определить среднюю цену товаров
        System.out.println("Cредняя цена на товары =" + srProduct(products));
        // и количество товаров с ценой нижесредней;
        System.out.println("\n Количество товаров с ценой нижесредней: ");
        double sred=srProduct(products);
        for (int i=0;i<products.length;i++){
            if(products[i].getPrice()<sred){
                System.out.println(products[i].getPrice());
            }
        }


        // 3.упорядочить список по убыванию цен товаров
        sortProduct(products);
        System.out.println("\n Отсортированный список по убыванию цен товаров: ");
        shProduct(products);


        // 4. организовать поиск по наименованию товара, исправление одного из его полей
        // и вывод полной информации о товаре после радактирования
        System.out.println("Введите название товара: ");
        Scanner sr = new Scanner(System.in);
        sr.nextLine();
        String smanufacturer = sr.nextLine();
        Product sfind = findForName(products,smanufacturer);
        if(sfind!=null){
            showProduct2(sfind);
        }else{
            System.out.println("Такого товара нету!!!");
        }
    }



    //1.метод определяющий товары с максимальным количеством единиц на складе в наличии
    public static int numberUnitsMAX(Product[]products){
        int numberMAX=0;
        int max = products[numberMAX].getNumberUnits();
        for(int i=0; i< products.length;i++)
            if(products[i].getNumberUnits()>max){
                max=products[i].getNumberUnits();
                numberMAX=i;
            }
        return numberMAX;
    }
    //и метод что бы показать производителя которому он соответствует
    private static void showProduct(Product product) {
        System.out.println(product.getManufacturer());
    }


    //2.метод определяющий среднюю цену товаров
    public static double srProduct(Product[]pr){
      double sum=0; //сумма всех товаров
        for (int i=0;i<pr.length;i++)
            sum+=pr[i].getPrice();//сумируем по цене
        double sr=sum/pr.length;//средняя цена товаров
        return sr;//и возвращаем значение
    }


    //3. метод позволяющий упорядочить список по убыванию цен товаров
    public static void sortProduct(Product[]pr){
        for (int i=0;i<pr.length-1;i++)
            for (int j=0;j<pr.length-1-i;j++)
                if(pr[j].getPrice()<pr[j+1].getPrice()){
                    Product x=pr[j];
                    pr[j]=pr[j+1];
                    pr[j+1]=x;
                }
    }
    //и метод позволяющий вывести массив
    private static void shProduct(Product[]pr) {
        for(int i=0;i<pr.length;i++)
        System.out.println(pr[i].getPrice() + "  " +pr[i].getManufacturer());
    }


    //4.Метод реализующий поиск по наименованию товара, исправление одного из его полей
    public static Product findForName(Product[]pr, String manufacturer){
        int n=-1;
        for(int i=0;i<pr.length;i++)
            if(manufacturer.equals(pr[i].getManufacturer()))
                n=i;
            if(n!=-1){
                return pr[n];
            }else return null;
    }
    //исправление одного из его полей
    //и вывод полной информации о товаре после радактирования
    private static void showProduct2(Product product) {
        product.setManufacturer("Вместо того что искали будет ВИТЯЗЬ");
        System.out.println(product.getName()+"  "+product.getManufacturer()+"  "+product.getPrice()+"рублей   "+product.getNumberUnits()+"шт. на складе");
    }




    TV tv = new TV("Samsung","SC20039");
    tv.show();

    Smartphone St = new Smartphone("Xiaomi");





}