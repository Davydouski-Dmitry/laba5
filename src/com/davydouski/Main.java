package com.davydouski;

//реализовать алгоритм работы с массивом данных объектов
//второй класс магазин, тут массив товаров

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
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


        //  0.определяем сколько объектов класса мы создали
        System.out.println("Количество созданных объектов = " + Product.getCounter());

        //  1.определить товары с максимальным количеством единиц;
        System.out.println("1.Определить товары с максимальным количеством единиц на складе:");
        int numberMAX = numberUnitsMAX(products);
        System.out.println("Фирма ноутбуков с максимальным количеством единиц на складе в наличии:");
        showProduct(products[numberMAX]);


        //  2.определить среднюю цену товаров
        System.out.println("2.Определить среднюю цену товаров, " +
                "и количество товаров с ценой нижесредней:");
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
        System.out.println("\n 3.Упорядочить список по убыванию цен товаров от большей к меньшей:");
        sortProduct(products);
        System.out.println("\n Отсортированный список по убыванию цен товаров: ");
        shProduct(products);


        // 4. организовать поиск по наименованию товара, исправление одного из его полей
        // и вывод полной информации о товаре после радактирования
        System.out.println("4. организовать поиск по наименованию товара, исправление одного из его полей\n" +
                "        и вывод полной информации о товаре после радактирования:");
        System.out.print("Введите название товара: ");
        Scanner sr = new Scanner(System.in);
        sr.nextLine();
        String smanufacturer = sr.nextLine();
        Product sfind = findForName(products,smanufacturer);
        if(sfind!=null){
            showProduct2(sfind);
        }else{
            System.out.println("Такого товара нету!!!");
        }



        TV tv1 = new TV("Samsung","SC20039",1278);
        TV tv2 = new TV("Lg","Shdfhg69",1975);

        tv1.show();//реализуем метод наследованный от абстрактного класса
        tv1.Print();//реализуем метод наследованный от интерфейса

        //реализуем интерфейс Comparable<TV>
        System.out.println("Реализуем интерфейс Comparable<TV> и сравним");
        int retval = tv1.compareTo(tv2);
        switch(retval) {
            case -1: {
                System.out.println("Этот " + tv2.getNameElectro() + " - более дорогой !");
                break;
            }
            case 1: {
                System.out.println("Этот " + tv1.getNameElectro() + " - более дорогой !");
                break;
            }
            default:
                System.out.println("Ого одинаковая цена !");
        }

        Smartphone St = new Smartphone("Xiaomi");
        St.show();
        St.Print();


        //сериализация
        String filename = "time.ser";
        if(args.length>0){
            filename=args[0];
        }
        HowTime time = new HowTime();
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try{
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(time);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Сериализация объекта:");
        System.out.println("Текущее время: "+ Calendar.getInstance().getTime());



//метод проверяющий скорость поиска по ArrayList и LinkedList
        compareLists();

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
        product.setManufacturer(" это поле исправим на - ВИТЯЗЬ");
        System.out.println(product.getName()+"  "+product.getManufacturer()+"  "+product.getPrice()+"рублей   "+product.getNumberUnits()+"шт. на складе");
    }


//метод проверяющий скорость поиска по ArrayList и LinkedList
    public static void compareLists() {
        ArrayList<Double> arrayList = new ArrayList<>();
        LinkedList<Double> linkedList = new LinkedList<>();
        final int number = 10000000;
        final int mrandom = 500;
        for (int i = 0; i < number; i++) {
            arrayList.add(Math.random());
            linkedList.add(Math.random());
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < mrandom; i++) {
            arrayList.get((int) (Math.random() * (number - 1)));
        }
        System.out.println("Время затраченое в миллисекундах на поиск по ArrayList нужных чисел - "+(System.currentTimeMillis() - startTime));


        startTime = System.currentTimeMillis();
        for (int i = 0; i < mrandom; i++) {
            linkedList.get((int) (Math.random() * (number - 1)));
        }
        System.out.println("Время затраченое в миллисекундах на поиск по linkedList нужных чисел - "+(System.currentTimeMillis() - startTime));
    }




}