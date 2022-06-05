package com.lzh.entity;

/**
 * @author: lzh
 * @date: 2022/5/28 14:06
 * @description:
 */
public class BreadCar extends Car {
    //载重量
    private int loads;

    public BreadCar() {
    }

    public BreadCar(String brand, int loads) {
        super(brand);
        this.loads = loads;
    }

    public BreadCar(String number, String brand, int money, int loads) {
        super(number, brand, money);
        this.loads = loads;
    }

    public int getLoads() {
        return loads;
    }

    public void setLoads(int loads) {
        this.loads = loads;
    }

    @Override
    public double allMoney(int days, double dayMoney) {
        if (days >= 31) {
            return days * dayMoney * 0.6;
        } else if (days >= 14) {
            return days * dayMoney * 0.7;
        } else if (days >= 7) {
            return days * dayMoney * 0.8;
        } else if (days >= 3) {
            return days * dayMoney * 0.9;
        } else
            return days * dayMoney;
    }
}
