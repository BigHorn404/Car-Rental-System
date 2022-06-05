package com.lzh;

import com.lzh.service.AppService;


/**
 * @author: lzh
 * @date: 2022/5/29 8:57
 * @description:
 */
public class App {
    public static void main(String[] args) {
        //获取appService对象
        AppService appService = new AppService();
        //欢迎界面，获取yes/no指令
        String order = appService.hello();
        //根据order，判断是管理员还是租车用户
        if("yes".equals(order) ||"y".equals(order)){
            //执行管理员操作
            appService.admin();
        }else {
            //执行普通用户操作
            appService.user();
        }
    }
}
