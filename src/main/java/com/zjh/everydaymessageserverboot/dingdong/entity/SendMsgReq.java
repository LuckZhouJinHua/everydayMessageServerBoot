package com.zjh.everydaymessageserverboot.dingdong.entity;

/**
 *@filename: SendMsgReq.java
 *@Describe:
 *@Author: Cole.zhou
 *@Date: 2022-08-26 13:44
 */
public class SendMsgReq {


    /*模板id*/
    private String templateId;

    /*用户id*/
    private String userId;

    /*正文*/
    private String content;

    public SendMsgReq(String templateId, String userId, String content) {
        this.templateId = templateId;
        this.userId = userId;
        this.content = content;
    }

    public SendMsgReq() {
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
