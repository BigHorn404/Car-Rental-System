package com.lzh.entity;

/**
 * @author: lzh
 * @date: 2022/5/28 13:44
 * @description:
 */
/*客车类*/
public class PassengerCar extends Car {
    //座位数
    private String seating;

    public PassengerCar() {
    }

    public PassengerCar(String brand, String seating) {
        super(brand);
        this.seating = seating;
    }

    public PassengerCar(String carNumber, String brand, int money, String seating) {
        super(carNumber, brand, money);
        this.seating = seating;
    }

    public String getSeating() {
        return seating;
    }

    public void setSeating(String seating) {
        this.seating = seating;
    }

    //重写租赁费用
    @Override
    public double allMoney(int days, double dayMoney) {
        if (days >= 150) {
            return days * dayMoney * 0.6;
        } else if (days >= 30) {
            return days * dayMoney * 0.7;
        } else if (days >= 7) {
            return days * dayMoney * 0.8;
        } else if (days >= 3) {
            return days * dayMoney * 0.9;
        } else
            return days * dayMoney;
    }
}
