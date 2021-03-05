package com.master.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Creqated by Limingxuan on 2021/3/5
 */
@Service
public class ScheduledService {

    //cron表达式
    //秒 分 时 日 月 周几
    /*
        "0 * * * * 0-7":每分钟当秒钟变为0时执行一次
     */
    /*
        0-10 * * * * ?:每分钟的0-10秒执行
     */
    /*
        30 0/5 10,18 * * ?:每天的10点和18点，每个5分钟执行一次
     */
    @Scheduled(cron = "0-10 * * * * ?")
    public void hello(){
        System.out.println(new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss").format(new Date()) + " 在特定时间执行这段代码");
    }
}
