package com.yangyang.threadPool;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yangyang on 2018/8/7.
 */
@Service
public class TimerTaskJob {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd:HH-mm-ss");

    @Scheduled(fixedRate = 2000)
    public void test() {
        System.out.println("定时任务："+ simpleDateFormat.format(new Date()));
    }

    @Scheduled(cron = "0 32 11 ? * *")
    public void test1() {
        System.out.println("在指定时间："+simpleDateFormat.format(new Date())+"执行");
    }

}
