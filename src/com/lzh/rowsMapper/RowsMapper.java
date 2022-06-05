package com.lzh.rowsMapper;

/**
 * @author: lzh
 * @date: 2022/5/28 15:21
 * @description:
 */

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 转换为行对象的接口
 * @param <T>
 */
public interface RowsMapper<T> {
    public T getEntity(ResultSet rs) throws SQLException;
}
