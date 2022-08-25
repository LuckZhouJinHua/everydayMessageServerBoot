package com.zjh.everydaymessageserverboot.dingdong.handel;

import com.zjh.everydaymessageserverboot.dingdong.entity.GirlFriend;
import com.zjh.everydaymessageserverboot.dingdong.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *@filename: SendMsg.java
 *@Describe:
 *@Author: Cole.zhou
 *@Date: 2022-08-24 10:32
 */
public class SendMsg {

    static String xiaofei = "o_st-57nd9HXV8Br8ZbloAvCVpS8";
    static String my = "o_st-5_rt_OAIBr3S6dPeECurmOc";

    public static void send() {
        Wx.init();
        GirlFriend girlFriend = new GirlFriend(Utils.getRandomName(), "湖北省", "武汉市", "1998-09-27", "2020-01-05", my);
        Wx.sendTemplateMessage(MessageFactory.resolveMessage(girlFriend));
    }

    public static void main(String[] args) {
        send();
    }

}
