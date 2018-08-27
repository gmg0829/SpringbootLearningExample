package com.example.springbootretry.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

/**
 * @author gmg
 * @Title:
 * @Package
 * @Description:
 * @date 2018/8/10  17:25
 */
@Service
public class PayService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private final int totalNum = 100000;


    @Retryable(value = Exception.class,maxAttempts = 3,backoff = @Backoff(delay = 2000,multiplier = 1.5))
    public int minGoodsnum(int num) throws Exception{
        logger.info("minGoodsnum开始"+ LocalTime.now());
        if(num <= 0){
            throw new Exception("数量不对");
        }
        logger.info("minGoodsnum执行结束");
        return totalNum - num;
    }

    @Recover
    public int recover(Exception e){
        logger.warn("减库存失败！！！");
        //记日志到数据库
        return totalNum;
    }

}
