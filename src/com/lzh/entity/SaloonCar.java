package com.lzh.entity;

/**
 * @author: lzh
 * @date: 2022/5/28 13:48
 * @description:
 */
/*轿车类*/
public class SaloonCar extends Car{
    private String type;//型号

    public SaloonCar() {
    }

    public SaloonCar(String brand, String type) {
        super(brand);
        this.type = type;
    }

    public SaloonCar(String carNumber, String brand, int money, String type) {
        super(carNumber, brand, money);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //重写租赁费用
    @Override
    public double allMoney(int days, double dayMoney) {
        if (days>150){
            return days*dayMoney*0.7;
        }else if (days>30){
            return days*dayMoney*0.8;
        }else if (days>7){
            return days*dayMoney*0.9;
        }else
            return days*dayMoney;
    }
}
