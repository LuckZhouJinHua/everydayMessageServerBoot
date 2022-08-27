package com.zjh.everydaymessageserverboot.dingdong.controller;

import com.zjh.everydaymessageserverboot.dingdong.entity.Friend;
import com.zjh.everydaymessageserverboot.dingdong.entity.GirlFriend;
import com.zjh.everydaymessageserverboot.dingdong.entity.SendMsgReq;
import com.zjh.everydaymessageserverboot.dingdong.handel.SendMsg;
import com.zjh.everydaymessageserverboot.dingdong.utils.ConfigConstants;
import com.zjh.everydaymessageserverboot.dingdong.utils.Utils;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping("/send")
    public String sendMyMsg(@RequestBody SendMsgReq msgReq) {
        Friend Friend = new Friend(msgReq.getContent(), "", "", msgReq.getUserId(), "2000-01-01", "", "", msgReq.getTemplateId());
        SendMsg.send(Friend, ConfigConstants.DEFAULT_TEMPLATE);
        return "发送成功!";
    }
}
