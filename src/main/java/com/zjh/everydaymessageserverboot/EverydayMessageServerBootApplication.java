package com.zjh.everydaymessageserverboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EverydayMessageServerBootApplication {
    private static final Logger logger = LoggerFactory.getLogger(EverydayMessageServerBootApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(EverydayMessageServerBootApplication.class, args);
        logger.info("定时推送微信公众号项目启动成功啦!");
    }
}
