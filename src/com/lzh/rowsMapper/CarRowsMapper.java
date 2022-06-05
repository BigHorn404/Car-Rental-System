package com.lzh.rowsMapper;

import com.lzh.entity.Car;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: lzh
 * @date: 2022/5/28 16:37
 * @description:
 */
public class CarRowsMapper implements RowsMapper<Car> {
    @Override
    public Car getEntity(ResultSet rs) throws SQLException {
        Car car = new Car();
        car.setId(rs.getInt("id"));
        car.setNumber(rs.getString("number"));
        car.setBrand(rs.getString("brand"));
        car.setMoney(rs.getInt("money"));
        return car;
    }
}
