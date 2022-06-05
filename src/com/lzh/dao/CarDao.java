package com.lzh.dao;


import com.lzh.entity.Car;

import java.util.List;

/**
 * @author: lzh
 * @date: 2022/5/28 15:51
 * @description:
 */
public interface CarDao {
    /**
     * 查询所有汽车信息
     * @return
     */
    List<Car> selectAll();

    /**
     * 根据id查询汽车信息
     * @return
     */
    Car selectById(int id);

    /**
     * 添加汽车信息
     * @param carEntity
     */
 void addCar(Car carEntity);

    /**
     * 根据id删除信息
     */
    public void deleteById(int id);

    /**
     * 修改汽车信息
     */
    public void editCar(Car carEntity);
}
