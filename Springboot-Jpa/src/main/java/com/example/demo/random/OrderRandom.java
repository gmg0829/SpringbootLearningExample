package com.example.demo.random;

import org.apache.commons.lang3.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by gmg on on 2017-12-22 17:26.
 */
public class OrderRandom {
    public static void main(String[] args) {
        System.out.println(genOrderNo("1","8001682"));
    }
    //业务编码 + 时间戳 + 机器编号[前4位] + 随机4位数。
    //业务编码（OrderType: Web=1 CallCenter=2 Wap=3）
    public static String genOrderNo(String orderType,String machine){
        Date curDate = new Date();
        String dateStr = new SimpleDateFormat("yyyyMMddHHmmss").format(curDate);
        String random = RandomStringUtils.random(4,false,true);
        String machineCode = machine.substring(0,4);
        return orderType+dateStr+machineCode+random;
    }
}
