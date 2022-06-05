package com.lzh.entity;

/**
 * @author: lzh
 * @date: 2022/5/28 12:50
 * @description:
 */
public  class Car {
    //在数据库中的id
    private int id;
    //车牌号
    private String number;
    //品牌种类
    private String brand;
    //日租金
    private int money;
    //无参构造方法
    public Car() {
    }

    public Car(String brand) {
        this.brand = brand;
    }

    public Car(String number, String brand, int money) {
        this.number = number;
        this.brand = brand;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    //租赁费用
    public double allMoney(int days, double dayMoney) {
        return 0;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", brand='" + brand + '\'' +
                ", money=" + money +
                '}';
    }
}
