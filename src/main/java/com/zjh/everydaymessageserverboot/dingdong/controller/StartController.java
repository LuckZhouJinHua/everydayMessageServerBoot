package com.zjh.everydaymessageserverboot.dingdong.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@filename: StartController.java
 *@Describe:
 *@Author: Cole.zhou
 *@Date: 2022-08-25 09:31
 */
@RestController
@RequestMapping("/start")
public class StartController {

    @RequestMapping("/getstr")
    public String returnString() {
        return "HelloWorld";
    }
}
