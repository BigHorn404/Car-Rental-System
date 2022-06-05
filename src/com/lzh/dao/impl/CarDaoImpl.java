package com.lzh.dao.impl;

import com.lzh.dao.CarDao;
import com.lzh.entity.Car;
import com.lzh.rowsMapper.CarRowsMapper;
import com.lzh.rowsMapper.RowsMapper;
import com.lzh.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author: lzh
 * @date: 2022/5/28 16:30
 * @description:
 */
public class CarDaoImpl implements CarDao {
    //查询所有汽车
    @Override
    public List<Car> selectAll() {
        List<Car> listCar = null;
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from car ";
            RowsMapper<Car> rm = new CarRowsMapper();
            Object[] paramsList = {};
            listCar = JdbcUtils.executeQuery(conn, sql, paramsList, rm);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return listCar;
    }


    @Override
    public Car selectById(int id) {
        Car car = new Car();
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from car where id=?";
            // 获取prStmt对象
            PreparedStatement prStmt = conn.prepareStatement(sql);
            prStmt.setInt(1, id);
            // 执行sql
            ResultSet rs = prStmt.executeQuery();
            if (rs.next()) {
                String number = rs.getString("number");
                String brand = rs.getString("brand");
                int money = rs.getInt("money");
                car.setId(id);
                car.setNumber(number);
                car.setBrand(brand);
                car.setMoney(money);
            }
            rs.close();
            prStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return car;
    }

    //增加汽车信息
    @Override
    public void addCar(Car carEntity) {
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into car (id,number,brand,money)";
            sql += " value (?,?,?,?)";
            Object[] params = {null, carEntity.getNumber(), carEntity.getBrand(), carEntity.getMoney()};
            JdbcUtils.insert(conn, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
    }

    //根据id删除汽车信息
    @Override
    public void deleteById(int id) {
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "delete from car where id=" + id;
            Object[] params = {};
            JdbcUtils.insert(conn, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
    }

    //修改汽车信息

    @Override
    public void editCar(Car carEntity) {
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "update car set money = ? where id = ?";
            Object[] params = {carEntity.getMoney(), carEntity.getId()};
            JdbcUtils.insert(conn, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
    }
}
