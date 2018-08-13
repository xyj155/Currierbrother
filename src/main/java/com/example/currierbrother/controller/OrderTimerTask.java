package com.example.currierbrother.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


@Configuration
@EnableScheduling // 启用定时任务
public class OrderTimerTask {
    /**
     * 定时推送派单
     */
    @Scheduled(cron = "0/20 * * * * ?")
    public void scheduler() {

    }
}
