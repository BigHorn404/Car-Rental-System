package com.lzh.service;

import com.lzh.dao.impl.CarDaoImpl;
import com.lzh.entity.Car;

import java.util.List;

/**
 * @author: lzh
 * @date: 2022/5/28 15:59
 * @description:
 */
public class CarService {
    private final CarDaoImpl carDao = new CarDaoImpl();

    //查询所有汽车
    public void selectAll() {
        System.out.println("\t\t\t\t汽车清单🚗");
        //打印汽车清单
        System.out.println("编号\t\t" + "车牌号\t\t" + "类型\t\t\t" + "日租金\t\t");
        List<Car> cars = carDao.selectAll();
        for (Car car : cars) {
            System.out.print(car.getId() + "\t\t");
            System.out.print(car.getNumber() + "\t\t");
            System.out.print(car.getBrand() + "\t\t");
            System.out.print(car.getMoney() + "\t\t");
            System.out.println();
        }
    }

    //添加汽车信息
    public void addCar(String number, String brand, int money) {
        Car carEntity = new Car(number, brand, money);
        carDao.addCar(carEntity);
    }

    //根据id删除汽车信息
    public void deleteById(int id) {
        carDao.deleteById(id);
    }

    //修改汽车信息
    public void editCar(int id,int money) {
        Car car = new Car();
        car.setMoney(money);
        car.setId(id);
        carDao.editCar(car);
    }

    //根据id查询汽车信息
    public Car selectById(int id) {
        return carDao.selectById(id);
    }
}
