package com.zjh.everydaymessageserverboot.dingdong.entity;

/**
 *@filename: TianXingInnerData.java
 *@Describe:
 *@Author: Cole.zhou
 *@Date: 2022-09-02 16:34
 */
public class TianXingInnerData {
    private String content;
    private String quest;//谜语大全
    private String answer;//谜语大全

    public TianXingInnerData() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getQuest() {
        return quest;
    }

    public void setQuest(String quest) {
        this.quest = quest;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
