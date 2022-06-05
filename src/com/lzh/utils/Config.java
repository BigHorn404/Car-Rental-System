package com.lzh.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author: lzh
 * @date: 2022/5/28 15:11
 * @description:
 */
public class Config {
    private Properties prop = new Properties();

    public Config(String file)
    {
        try
        {
            InputStream in = new FileInputStream(file);
            prop.load(in);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public String getValue(String key)
    {
        return prop.getProperty(key);
    }
}
