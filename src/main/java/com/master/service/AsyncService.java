package com.master.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Creqated by Limingxuan on 2021/3/4
 */

@Service
public class AsyncService {

    //告诉Spring这是个异步的方法
    @Async
    public void hello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("正在处理数据。。。");
    }
}
