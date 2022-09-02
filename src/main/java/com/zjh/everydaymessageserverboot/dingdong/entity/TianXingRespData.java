package com.zjh.everydaymessageserverboot.dingdong.entity;

import java.util.List;

/**
 *@filename: TianXingRespData.java
 *@Describe: 调用天行接口返回的数据
 *@Author: Cole.zhou
 *@Date: 2022-08-29 16:15
 */
public class TianXingRespData {

    private String code;

    private String msg;

    private List<TianXingInnerData> newslist;

    public TianXingRespData() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<TianXingInnerData> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<TianXingInnerData> newslist) {
        this.newslist = newslist;
    }
}




