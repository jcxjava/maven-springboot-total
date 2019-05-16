package com.jiangcx.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jiangcx on 2019/3/12
 * springboot定时器练习
 * @Scheduled(fixedRate = 6000) ：上一次开始执行时间点之后6秒再执行
 * @Scheduled(fixedDelay = 6000) ：上一次执行完毕时间点之后6秒再执行
 * @Scheduled(initialDelay=1000, fixedRate=6000) ：第一次延迟1秒后执行，之后按fixedRate的规则每6秒执行一次
 */
@Component
public class ScheduleTask {

    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void testScheduleTask(){
        System.out.println("当前时间："+sdf.format(new Date()));
    }
}
