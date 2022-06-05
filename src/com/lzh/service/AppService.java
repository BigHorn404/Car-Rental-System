package com.lzh.service;

import com.lzh.entity.BreadCar;
import com.lzh.entity.Car;
import com.lzh.entity.PassengerCar;
import com.lzh.entity.SaloonCar;

import java.util.Scanner;

/**
 * @author: lzh
 * @date: 2022/5/28 16:01
 * @description:
 */
public class AppService {
    Scanner sc = new Scanner(System.in);
    public  String hello(){
        System.out.println("**********欢迎使用汽车租车系统**********");
        System.out.println("是否为管理员？ yes/no");
        return sc.nextLine();
    }

    public void admin() {
        CarService carService = new CarService();
        System.out.println("欢迎你，管理员！");
        System.out.println("a.增加汽车信息\n"+"b.修改汽车租金\n"+"c.删除汽车信息");
        System.out.println("请选择你的操作(输入字母)：");
        String order = sc.nextLine();
        carService.selectAll();
        switch (order){
            case "a":
                System.out.println("请输入要添加的车牌号");
                String number = sc.nextLine();
                System.out.println("请输入要添加的车种类");
                String brand = sc.nextLine();
                System.out.println("请输入要添加的日租金");
                int money = sc.nextInt();
                //添加汽车表数据
                carService.addCar(number,brand,money);
                //查询添加后的汽车表
                carService.selectAll();
                break;
            case "b":
                System.out.println("请输入你要修改的汽车的编号");
                int id1 = sc.nextInt();
                System.out.println("请输入修改后的日租金");
                int money1 = sc.nextInt();
                //更新汽车表数据
                carService.editCar(id1,money1);
                //查询修改后的汽车表
                carService.selectAll();
                break;
            case "c":
                System.out.println("请输入你要删除的汽车的编号");
                int id2 = sc.nextInt();
                //删除汽车表数据
                carService.deleteById(id2);
                //查询删除后的汽车表
                carService.selectAll();
                break;
            default:
                break;
        }

    }

    public void user() {
        System.out.println("欢迎您，尊敬的客户！");
        CarService carService = new CarService();
        carService.selectAll();
        System.out.println("请输入租赁汽车编号:");
        int id = sc.nextInt();
        System.out.println("请输入需要租赁的天数:");
        int days = sc.nextInt();
        //根据id在数据库中查询该汽车信息
        Car car = carService.selectById(id);
        //获取该车的日租金
        int dayMoney = car.getMoney();
        //获取该车的类型
        String brand = car.getBrand();
        switch (brand) {
            case "大客车":
                PassengerCar passengerCar = new PassengerCar();
                double rentP = passengerCar.allMoney(days, dayMoney);
                System.out.println("所需租金：" + rentP);
                break;
            case "小轿车":
                SaloonCar saloonCar = new SaloonCar();
                double rentS = saloonCar.allMoney(days, dayMoney);
                System.out.println("所需租金：" + rentS);
                break;
            case "面包车":
                BreadCar breadCar = new BreadCar();
                double rentB = breadCar.allMoney(days, dayMoney);
                System.out.println("所需租金：" + rentB);
                break;
        }
    }
}
