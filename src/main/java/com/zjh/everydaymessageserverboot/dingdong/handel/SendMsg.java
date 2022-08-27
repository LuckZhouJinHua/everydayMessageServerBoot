package com.zjh.everydaymessageserverboot.dingdong.handel;

import cn.hutool.core.util.StrUtil;
import com.zjh.everydaymessageserverboot.dingdong.entity.Friend;
import com.zjh.everydaymessageserverboot.dingdong.enums.TemplateTypeEnum;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;

/**
 *@filename: SendMsg.java
 *@Describe:
 *@Author: Cole.zhou
 *@Date: 2022-08-24 10:32
 */
public class SendMsg {

    /**
     * @Description: 发送消息
     * @Param: [friend, msgType]
     * @return: void
     * @Author: cole.zhou
     * @Date: 2022/8/26 上午 9:50
     */
    public static void send(Friend friend, String msgType) {


        Wx.init();
        WxMpTemplateMessage wxMpTemplateMessage = WxMpTemplateMessage.builder()
                .url("https://ofpp.cn") // 点击后的跳转链接 可自行修改 也可以不填
                .toUser(friend.getUserId())
                .templateId(StrUtil.emptyToDefault(friend.getTemplateId(), TemplateTypeEnum.getTemplateType(msgType)))
                .data(MessageFactory.getTemplateData(friend, msgType)).build();
        Wx.sendTemplateMessage(wxMpTemplateMessage);
    }
}
