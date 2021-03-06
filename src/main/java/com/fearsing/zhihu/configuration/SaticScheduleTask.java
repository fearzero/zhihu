package com.fearsing.zhihu.configuration;

import com.fearsing.zhihu.service.HotListService;
import com.fearsing.zhihu.service.impl.HotListServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class SaticScheduleTask {

    private static Logger log = LoggerFactory.getLogger(HotListServiceImpl.class);
    @Autowired
    HotListService service;
    //3.添加定时任务
    @Scheduled(cron = "00 00,30  * * * ?")
    //或直接指定时间间隔，例如：5秒
//    @Scheduled(fixedRate=5*1000)
    private void configureTasks() {
        service.insert();
        log.info("执行静态定时任务时间: " + LocalDateTime.now());

    }
}
